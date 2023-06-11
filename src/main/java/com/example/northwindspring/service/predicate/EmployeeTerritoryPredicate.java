package com.example.northwindspring.service.predicate;

import com.example.northwindspring.dto.search_dto.EmployeeTerritorySearchDto;
import com.example.northwindspring.dto.search_dto.ProductSearchDto;
import com.example.northwindspring.entity.QEmployeeTerritory;
import com.example.northwindspring.entity.QProduct;
import com.querydsl.core.BooleanBuilder;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;

public class EmployeeTerritoryPredicate {

  private static final QEmployeeTerritory qEmployeeTerritory = QEmployeeTerritory.employeeTerritory;

  public static BooleanBuilder makePredicate(EmployeeTerritorySearchDto employeeTerritorySearchDto) {

    BooleanBuilder builder = new BooleanBuilder();
    if (!CollectionUtils.isEmpty(employeeTerritorySearchDto.getIdList())) {
      builder.and(qEmployeeTerritory.id.in(employeeTerritorySearchDto.getIdList()));
    }

    if (StringUtils.isNotBlank(employeeTerritorySearchDto.getIdNotEqual())) {
      builder.and(qEmployeeTerritory.id.ne(employeeTerritorySearchDto.getIdNotEqual()));
    }

    return builder;

  }
}