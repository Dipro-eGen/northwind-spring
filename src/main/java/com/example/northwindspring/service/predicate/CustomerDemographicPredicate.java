package com.example.northwindspring.service.predicate;

import com.example.northwindspring.dto.search_dto.CustomerDemographicSearchDto;
import com.example.northwindspring.dto.search_dto.ProductSearchDto;
import com.example.northwindspring.entity.QCustomerDemographic;
import com.example.northwindspring.entity.QProduct;
import com.querydsl.core.BooleanBuilder;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;

public class CustomerDemographicPredicate {

  private static final QCustomerDemographic qCustomerDemographic = QCustomerDemographic.customerDemographic;

  public static BooleanBuilder makePredicate(CustomerDemographicSearchDto customerDemographicSearchDto) {

    BooleanBuilder builder = new BooleanBuilder();
    if (!CollectionUtils.isEmpty(customerDemographicSearchDto.getIdList())) {
      builder.and(qCustomerDemographic.id.in(customerDemographicSearchDto.getIdList()));
    }

    if (StringUtils.isNotBlank(customerDemographicSearchDto.getIdNotEqual())) {
      builder.and(qCustomerDemographic.id.ne(customerDemographicSearchDto.getIdNotEqual()));
    }

    return builder;
  }

}
