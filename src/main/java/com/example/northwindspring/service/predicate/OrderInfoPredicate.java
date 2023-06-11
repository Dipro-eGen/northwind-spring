package com.example.northwindspring.service.predicate;

import com.example.northwindspring.dto.search_dto.OrderInfoSearchDto;
import com.example.northwindspring.dto.search_dto.ProductSearchDto;
import com.example.northwindspring.entity.QOrderInfo;
import com.example.northwindspring.entity.QProduct;
import com.querydsl.core.BooleanBuilder;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;

public class OrderInfoPredicate {

  private static final QOrderInfo qOrderInfo = QOrderInfo.orderInfo;

  public static BooleanBuilder makePredicate(OrderInfoSearchDto orderInfoSearchDto) {

    BooleanBuilder builder = new BooleanBuilder();
    if (!CollectionUtils.isEmpty(orderInfoSearchDto.getIdList())) {
      builder.and(qOrderInfo.id.in(orderInfoSearchDto.getIdList()));
    }
    if (StringUtils.isNotBlank(orderInfoSearchDto.getId())) {
      builder.and(qOrderInfo.id.eq(orderInfoSearchDto.getId()));
    }
    if (StringUtils.isNotBlank(orderInfoSearchDto.getIdNotEqual())) {
      builder.and(qOrderInfo.id.ne(orderInfoSearchDto.getIdNotEqual()));
    }

    return builder;
  }

}
