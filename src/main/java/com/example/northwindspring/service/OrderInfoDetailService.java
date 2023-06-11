package com.example.northwindspring.service;


import com.example.northwindspring.dto.search_dto.OrderInfoDetailSearchDto;
import com.example.northwindspring.dto.search_dto.OrderInfoSearchDto;
import com.example.northwindspring.entity.OrderInfo;
import com.example.northwindspring.entity.OrderInfoDetail;
import com.example.northwindspring.entity.QOrderInfo;
import com.example.northwindspring.entity.QOrderInfoDetail;
import com.example.northwindspring.repository.OrderInfoDetailRepository;
import com.example.northwindspring.repository.OrderInfoRepository;
import com.example.northwindspring.service.predicate.OrderInfoDetailPredicate;
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
public class OrderInfoDetailService {

  private final EntityManager entityManager;
  private final OrderInfoDetailRepository orderInfoDetailRepository;


  public OrderInfoDetail save(OrderInfoDetail orderInfoDetail) {
    return orderInfoDetailRepository.save(orderInfoDetail);
  }


  public Page<OrderInfoDetail> search(OrderInfoDetailSearchDto orderInfoDetailSearchDto) {
    final QOrderInfoDetail qOrderInfoDetail = QOrderInfoDetail.orderInfoDetail;
    final JPAQuery<OrderInfoDetail> query = new JPAQuery<>(entityManager);

    Predicate predicate = OrderInfoDetailPredicate.makePredicate(orderInfoDetailSearchDto);
    Pageable pageable = PageRequest.of(orderInfoDetailSearchDto.getPage(), orderInfoDetailSearchDto.getSize());

    var orderInfoDetailJPAQuery = query.from(qOrderInfoDetail)
      .where(predicate)
      .limit(pageable.getPageSize())
      .offset(pageable.getOffset())
      //.orderBy(dept.createdDate.desc())
      ;
    return new PageImpl<>(orderInfoDetailJPAQuery.fetch(), pageable, orderInfoDetailJPAQuery.fetchCount());
  }


}