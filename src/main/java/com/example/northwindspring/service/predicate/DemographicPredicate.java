package com.example.northwindspring.service.predicate;

import com.example.northwindspring.dto.search_dto.DemographicSearchDto;
import com.example.northwindspring.dto.search_dto.ProductSearchDto;
import com.example.northwindspring.entity.QDemographic;
import com.example.northwindspring.entity.QProduct;
import com.querydsl.core.BooleanBuilder;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;

public class DemographicPredicate {

  private static final QDemographic qDemographic = QDemographic.demographic;

  public static BooleanBuilder makePredicate(DemographicSearchDto demographicSearchDto) {

    BooleanBuilder builder = new BooleanBuilder();
    if (!CollectionUtils.isEmpty(demographicSearchDto.getIdList())) {
      builder.and(qDemographic.id.in(demographicSearchDto.getIdList()));
    }

    if (StringUtils.isNotBlank(demographicSearchDto.getName())) {
      builder.and(qDemographic.description.eq(demographicSearchDto.getName()));
    }
    if (StringUtils.isNotBlank(demographicSearchDto.getNameIgnoreCase())) {
      builder.and(qDemographic.description.equalsIgnoreCase(demographicSearchDto.getNameIgnoreCase()));
    }
    if (StringUtils.isNotBlank(demographicSearchDto.getIdNotEqual())) {
      builder.and(qDemographic.id.ne(demographicSearchDto.getIdNotEqual()));
    }

    BooleanBuilder orBuilder = new BooleanBuilder();
    if (!StringUtils.isEmpty(demographicSearchDto.getMultiSearchProp())) {
      orBuilder.or(qDemographic.description.containsIgnoreCase(demographicSearchDto.getMultiSearchProp()));
    }
    return builder.and(orBuilder);
  }

}
