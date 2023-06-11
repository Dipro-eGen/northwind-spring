package com.example.northwindspring.service.predicate;

import com.example.northwindspring.dto.search_dto.ProductSearchDto;
import com.example.northwindspring.dto.search_dto.RegionSearchDto;
import com.example.northwindspring.entity.QProduct;
import com.example.northwindspring.entity.QRegion;
import com.querydsl.core.BooleanBuilder;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;

public class RegionPredicate {

  private static final QRegion qRegion = QRegion.region;

  public static BooleanBuilder makePredicate(RegionSearchDto regionSearchDto) {

    BooleanBuilder builder = new BooleanBuilder();
    if (!CollectionUtils.isEmpty(regionSearchDto.getIdList())) {
      builder.and(qRegion.id.in(regionSearchDto.getIdList()));
    }
    if (StringUtils.isNotBlank(regionSearchDto.getIdNotEqual())) {
      builder.and(qRegion.id.ne(regionSearchDto.getIdNotEqual()));
    }

    return builder;
  }

}
