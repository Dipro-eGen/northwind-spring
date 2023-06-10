package com.example.northwindspring.service.predicate;

import com.example.northwindspring.dto.search_dto.ProductSearchDto;
import com.example.northwindspring.entity.QProduct;
import com.querydsl.core.BooleanBuilder;
import io.micrometer.common.util.StringUtils;

import org.springframework.util.CollectionUtils;

import java.util.Objects;

public class ProductPredicate {

  private static final QProduct qProduct = QProduct.product;

  public static BooleanBuilder makePredicate(ProductSearchDto productSearchDto) {

    BooleanBuilder builder = new BooleanBuilder();
    if (!CollectionUtils.isEmpty(productSearchDto.getIdList())) {
      builder.and(qProduct.id.in(productSearchDto.getIdList()));
    }

    if (StringUtils.isNotBlank(productSearchDto.getName())) {
      builder.and(qProduct.name.eq(productSearchDto.getName()));
    }
    if (StringUtils.isNotBlank(productSearchDto.getNameIgnoreCase())) {
      builder.and(qProduct.name.equalsIgnoreCase(productSearchDto.getNameIgnoreCase()));
    }
    if (StringUtils.isNotBlank(productSearchDto.getIdNotEqual())) {
      builder.and(qProduct.id.ne(productSearchDto.getIdNotEqual()));
    }

    BooleanBuilder orBuilder = new BooleanBuilder();
    if (!StringUtils.isEmpty(productSearchDto.getMultiSearchProp())) {
      orBuilder.or(qProduct.name.containsIgnoreCase(productSearchDto.getMultiSearchProp()));
    }
    return builder.and(orBuilder);
  }

}
