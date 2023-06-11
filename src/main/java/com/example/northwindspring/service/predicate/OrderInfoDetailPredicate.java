package com.example.northwindspring.service.predicate;

import com.example.northwindspring.dto.search_dto.OrderInfoSearchDto;
import com.example.northwindspring.dto.search_dto.ProductSearchDto;
import com.example.northwindspring.entity.QOrderInfoDetail;
import com.example.northwindspring.entity.QProduct;
import com.querydsl.core.BooleanBuilder;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;

public class OrderInfoDetailPredicate {

  private static final QOrderInfoDetail qOrderInfoDetail = QOrderInfoDetail.orderInfoDetail;

  public static BooleanBuilder makePredicate(OrderInfoSearchDto orderInfoSearchDto) {

    BooleanBuilder builder = new BooleanBuilder();
    if (!CollectionUtils.isEmpty(orderInfoSearchDto.getIdList())) {
      builder.and(qOrderInfoDetail.id.in(orderInfoSearchDto.getIdList()));
    }

    if (StringUtils.isNotBlank(orderInfoSearchDto.getIdNotEqual())) {
      builder.and(qOrderInfoDetail.id.ne(orderInfoSearchDto.getIdNotEqual()));
    }
    return builder;
  }

}
