package com.example.northwindspring.service.predicate;

import com.example.northwindspring.dto.search_dto.ProductSearchDto;
import com.example.northwindspring.dto.search_dto.TerritorySearchDto;
import com.example.northwindspring.entity.QProduct;
import com.example.northwindspring.entity.QTerritory;
import com.querydsl.core.BooleanBuilder;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;

public class TerritoryPredicate {

  private static final QTerritory qTerritory = QTerritory.territory;

  public static BooleanBuilder makePredicate(TerritorySearchDto territorySearchDto) {

    BooleanBuilder builder = new BooleanBuilder();
    if (!CollectionUtils.isEmpty(territorySearchDto.getIdList())) {
      builder.and(qTerritory.id.in(territorySearchDto.getIdList()));
    }
    if (StringUtils.isNotBlank(territorySearchDto.getIdNotEqual())) {
      builder.and(qTerritory.id.ne(territorySearchDto.getIdNotEqual()));
    }

    return builder;
  }

}
