package com.example.northwindspring.service.predicate;

import com.example.northwindspring.dto.search_dto.ProductSearchDto;
import com.example.northwindspring.dto.search_dto.ShipperSearchDto;
import com.example.northwindspring.entity.QProduct;
import com.example.northwindspring.entity.QShipper;
import com.querydsl.core.BooleanBuilder;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;

public class ShipperPredicate {

  private static final QShipper qShipper = QShipper.shipper;

  public static BooleanBuilder makePredicate(ShipperSearchDto shipperSearchDto) {

    BooleanBuilder builder = new BooleanBuilder();
    if (!CollectionUtils.isEmpty(shipperSearchDto.getIdList())) {
      builder.and(qShipper.id.in(shipperSearchDto.getIdList()));
    }
    if (StringUtils.isNotBlank(shipperSearchDto.getIdNotEqual())) {
      builder.and(qShipper.id.ne(shipperSearchDto.getIdNotEqual()));
    }
    return builder;
  }

}
