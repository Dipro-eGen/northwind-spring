package com.example.northwindspring.service;


import com.example.northwindspring.dto.search_dto.OrderInfoSearchDto;
import com.example.northwindspring.entity.OrderInfo;
import com.example.northwindspring.entity.QOrderInfo;
import com.example.northwindspring.entity.QOrderInfoDetail;
import com.example.northwindspring.repository.OrderInfoDetailRepository;
import com.example.northwindspring.repository.OrderInfoRepository;
import com.example.northwindspring.service.predicate.OrderInfoPredicate;
import com.example.northwindspring.util.EntityTransformUtil;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service

@RequiredArgsConstructor
public class OrderInfoService {

  private final EntityManager entityManager;
  private final OrderInfoRepository orderInfoRepository;
  private final OrderInfoDetailRepository orderInfoDetailRepository;
  private final OrderInfoDetailService orderInfoDetailService;


  @Transactional
  public OrderInfo save(OrderInfo orderInfo) {
    var orderFromDb = orderInfoRepository.save(orderInfo);

    orderInfoDetailRepository.saveAll(
      orderInfo.getOrderInfoDetailList().parallelStream().map(
        e -> e.setOrderInfo(new OrderInfo(orderFromDb.getId()))).toList());


 /*   if (orderInfo.getOrderInfoDetailList().size() > 0) {
      orderInfo.getOrderInfoDetailList().forEach(e -> {
        e.setOrderInfo(new OrderInfo(orderFromDb.getId()));
        orderInfoDetailService.save(e);
      });
    }*/
    return orderFromDb;
  }


  public Page<OrderInfo> search(OrderInfoSearchDto orderInfoSearchDto) {
    final QOrderInfo qOrderInfo = QOrderInfo.orderInfo;
    final QOrderInfoDetail qOrderInfoDetail = QOrderInfoDetail.orderInfoDetail;
    final JPAQuery<OrderInfo> query = new JPAQuery<>(entityManager);

    Predicate predicate = OrderInfoPredicate.makePredicate(orderInfoSearchDto);
    Pageable pageable = PageRequest.of(orderInfoSearchDto.getPage(), orderInfoSearchDto.getSize());

    var orderInfoJPAQuery = query.from(qOrderInfo)
      .leftJoin(qOrderInfo.orderInfoDetailList, qOrderInfoDetail).fetchJoin()
      .where(predicate)
      .limit(pageable.getPageSize())
      .offset(pageable.getOffset());

    List<OrderInfo> orderInfoList = orderInfoJPAQuery.fetch();

    List<OrderInfo> orderInfoListNew = orderInfoList.parallelStream().map(orderInfo -> {
      var t = EntityTransformUtil.copyValueProp(orderInfo);
      t.setOrderInfoDetailList(EntityTransformUtil.copyList(t.getOrderInfoDetailList()));
      return t;
    }).toList();

    return new PageImpl<>(orderInfoListNew, pageable, orderInfoJPAQuery.fetchCount());
  }


}

