package com.example.northwindspring.service.predicate;

import com.example.northwindspring.dto.search_dto.CategorySearchDto;
import com.example.northwindspring.dto.search_dto.SupplierSearchDto;
import com.example.northwindspring.entity.QCategory;
import com.example.northwindspring.entity.QSupplier;
import com.querydsl.core.BooleanBuilder;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;

public class SupplierPredicate {

  private static final QSupplier qSupplier = QSupplier.supplier;

  public static BooleanBuilder makePredicate(SupplierSearchDto supplierSearchDto) {

    BooleanBuilder builder = new BooleanBuilder();
    if (!CollectionUtils.isEmpty(supplierSearchDto.getIdList())) {
      builder.and(qSupplier.id.in(supplierSearchDto.getIdList()));
    }

    if (StringUtils.isNotBlank(supplierSearchDto.getIdNotEqual())) {
      builder.and(qSupplier.id.ne(supplierSearchDto.getIdNotEqual()));
    }

    return builder;
  }

}
