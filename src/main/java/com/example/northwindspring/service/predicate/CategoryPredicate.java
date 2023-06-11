package com.example.northwindspring.service.predicate;

import com.example.northwindspring.dto.search_dto.CategorySearchDto;
import com.example.northwindspring.dto.search_dto.ProductSearchDto;
import com.example.northwindspring.entity.QCategory;
import com.example.northwindspring.entity.QProduct;
import com.querydsl.core.BooleanBuilder;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;

public class CategoryPredicate {

  private static final QCategory qCategory = QCategory.category;

  public static BooleanBuilder makePredicate(CategorySearchDto categorySearchDto) {

    BooleanBuilder builder = new BooleanBuilder();
    if (!CollectionUtils.isEmpty(categorySearchDto.getIdList())) {
      builder.and(qCategory.id.in(categorySearchDto.getIdList()));
    }

    if (StringUtils.isNotBlank(categorySearchDto.getName())) {
      builder.and(qCategory.name.eq(categorySearchDto.getName()));
    }
    if (StringUtils.isNotBlank(categorySearchDto.getNameIgnoreCase())) {
      builder.and(qCategory.name.equalsIgnoreCase(categorySearchDto.getNameIgnoreCase()));
    }
    if (StringUtils.isNotBlank(categorySearchDto.getIdNotEqual())) {
      builder.and(qCategory.id.ne(categorySearchDto.getIdNotEqual()));
    }

    BooleanBuilder orBuilder = new BooleanBuilder();
    if (!StringUtils.isEmpty(categorySearchDto.getMultiSearchProp())) {
      orBuilder.or(qCategory.name.containsIgnoreCase(categorySearchDto.getMultiSearchProp()));
    }
    return builder.and(orBuilder);
  }

}
