package com.example.northwindspring.service.predicate;

import com.example.northwindspring.dto.search_dto.OrderInfoDetailSearchDto;
import com.example.northwindspring.dto.search_dto.OrderInfoSearchDto;
import com.example.northwindspring.dto.search_dto.ProductSearchDto;
import com.example.northwindspring.entity.QOrderInfoDetail;
import com.example.northwindspring.entity.QProduct;
import com.querydsl.core.BooleanBuilder;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;

public class OrderInfoDetailPredicate {

  private static final QOrderInfoDetail qOrderInfoDetail = QOrderInfoDetail.orderInfoDetail;

  public static BooleanBuilder makePredicate(OrderInfoDetailSearchDto orderInfoDetailSearchDto) {

    BooleanBuilder builder = new BooleanBuilder();
    if (!CollectionUtils.isEmpty(orderInfoDetailSearchDto.getIdList())) {
      builder.and(qOrderInfoDetail.id.in(orderInfoDetailSearchDto.getIdList()));
    }

    if (StringUtils.isNotBlank(orderInfoDetailSearchDto.getIdNotEqual())) {
      builder.and(qOrderInfoDetail.id.ne(orderInfoDetailSearchDto.getIdNotEqual()));
    }
    return builder;
  }

}
