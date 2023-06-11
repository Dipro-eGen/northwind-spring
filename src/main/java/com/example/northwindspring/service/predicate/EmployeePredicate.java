package com.example.northwindspring.service.predicate;

import com.example.northwindspring.dto.search_dto.EmployeeSearchDto;
import com.example.northwindspring.dto.search_dto.ProductSearchDto;
import com.example.northwindspring.entity.QEmployee;
import com.example.northwindspring.entity.QProduct;
import com.querydsl.core.BooleanBuilder;
import io.micrometer.common.util.StringUtils;
import org.springframework.util.CollectionUtils;

public class EmployeePredicate {

  private static final QEmployee qEmployee = QEmployee.employee;

  public static BooleanBuilder makePredicate(EmployeeSearchDto employeeSearchDto) {

    BooleanBuilder builder = new BooleanBuilder();
    if (!CollectionUtils.isEmpty(employeeSearchDto.getIdList())) {
      builder.and(qEmployee.id.in(employeeSearchDto.getIdList()));
    }

    if (StringUtils.isNotBlank(employeeSearchDto.getName())) {
      builder.and(qEmployee.name.eq(employeeSearchDto.getName()));
    }
    if (StringUtils.isNotBlank(employeeSearchDto.getNameIgnoreCase())) {
      builder.and(qEmployee.name.equalsIgnoreCase(employeeSearchDto.getNameIgnoreCase()));
    }
    if (StringUtils.isNotBlank(employeeSearchDto.getIdNotEqual())) {
      builder.and(qEmployee.id.ne(employeeSearchDto.getIdNotEqual()));
    }

    BooleanBuilder orBuilder = new BooleanBuilder();
    if (!StringUtils.isEmpty(employeeSearchDto.getMultiSearchProp())) {
      orBuilder.or(qEmployee.name.containsIgnoreCase(employeeSearchDto.getMultiSearchProp()));
    }
    return builder.and(orBuilder);
  }

}
