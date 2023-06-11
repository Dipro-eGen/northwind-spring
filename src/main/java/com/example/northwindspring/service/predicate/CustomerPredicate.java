package com.example.northwindspring.service.predicate;

import com.example.northwindspring.dto.search_dto.CustomerSearchDto;
import com.example.northwindspring.dto.search_dto.ProductSearchDto;
import com.example.northwindspring.entity.QCustomer;
import com.example.northwindspring.entity.QProduct;
import com.querydsl.core.BooleanBuilder;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;

public class CustomerPredicate {

  private static final QCustomer qCustomer = QCustomer.customer;

  public static BooleanBuilder makePredicate(CustomerSearchDto customerSearchDto) {

    BooleanBuilder builder = new BooleanBuilder();
    if (!CollectionUtils.isEmpty(customerSearchDto.getIdList())) {
      builder.and(qCustomer.id.in(customerSearchDto.getIdList()));
    }

    if (StringUtils.isNotBlank(customerSearchDto.getName())) {
      builder.and(qCustomer.contractName.eq(customerSearchDto.getName()));
    }
    if (StringUtils.isNotBlank(customerSearchDto.getNameIgnoreCase())) {
      builder.and(qCustomer.contractName.equalsIgnoreCase(customerSearchDto.getNameIgnoreCase()));
    }
    if (StringUtils.isNotBlank(customerSearchDto.getIdNotEqual())) {
      builder.and(qCustomer.id.ne(customerSearchDto.getIdNotEqual()));
    }

    BooleanBuilder orBuilder = new BooleanBuilder();
    if (!StringUtils.isEmpty(customerSearchDto.getMultiSearchProp())) {
      orBuilder.or(qCustomer.contractName.containsIgnoreCase(customerSearchDto.getMultiSearchProp()));
    }
    return builder.and(orBuilder);
  }

}
