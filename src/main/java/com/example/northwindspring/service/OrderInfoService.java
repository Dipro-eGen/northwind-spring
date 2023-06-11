package com.example.northwindspring.service;


import com.example.northwindspring.dto.search_dto.OrderInfoSearchDto;
import com.example.northwindspring.entity.OrderInfo;
import com.example.northwindspring.entity.QOrderInfo;
import com.example.northwindspring.repository.OrderInfoRepository;
import com.example.northwindspring.service.predicate.OrderInfoPredicate;
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


@Service
@Transactional
@RequiredArgsConstructor
public class OrderInfoService {

  private final EntityManager entityManager;
  private final OrderInfoRepository orderInfoRepository;


  public OrderInfo save(OrderInfo orderInfo) {
    return orderInfoRepository.save(orderInfo);
  }


  public Page<OrderInfo> search(OrderInfoSearchDto orderInfoSearchDto) {
    final QOrderInfo qOrderInfo = QOrderInfo.orderInfo;
    final JPAQuery<OrderInfo> query = new JPAQuery<>(entityManager);

    Predicate predicate = OrderInfoPredicate.makePredicate(orderInfoSearchDto);
    Pageable pageable = PageRequest.of(orderInfoSearchDto.getPage(), orderInfoSearchDto.getSize());

    var orderInfoJPAQuery = query.from(qOrderInfo)
      .where(predicate)
      .limit(pageable.getPageSize())
      .offset(pageable.getOffset())
      //.orderBy(dept.createdDate.desc())
      ;
    return new PageImpl<>(orderInfoJPAQuery.fetch(), pageable, orderInfoJPAQuery.fetchCount());
  }


}