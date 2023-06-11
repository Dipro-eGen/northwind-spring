package com.example.northwindspring.service;


import com.example.northwindspring.dto.search_dto.EmployeeTerritorySearchDto;
import com.example.northwindspring.dto.search_dto.ProductSearchDto;
import com.example.northwindspring.entity.EmployeeTerritory;
import com.example.northwindspring.entity.EmployeeTerritory;
import com.example.northwindspring.entity.QEmployeeTerritory;
import com.example.northwindspring.entity.QProduct;
import com.example.northwindspring.repository.EmployeeTerritoryRepository;
import com.example.northwindspring.repository.ProductRepository;
import com.example.northwindspring.service.predicate.EmployeeTerritoryPredicate;
import com.example.northwindspring.service.predicate.ProductPredicate;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeTerritoryService {

  private final EntityManager entityManager;
  private final EmployeeTerritoryRepository employeeTerritoryRepository;


  public EmployeeTerritory save(EmployeeTerritory employeeTerritory) {
    return employeeTerritoryRepository.save(employeeTerritory);
  }


  public Page<EmployeeTerritory> search(EmployeeTerritorySearchDto employeeTerritorySearchDto) {
    final QEmployeeTerritory qEmployeeTerritory = QEmployeeTerritory.employeeTerritory;
    final JPAQuery<EmployeeTerritory> query = new JPAQuery<>(entityManager);

    Predicate predicate = EmployeeTerritoryPredicate.makePredicate(employeeTerritorySearchDto);
    Pageable pageable = PageRequest.of(employeeTerritorySearchDto.getPage(), employeeTerritorySearchDto.getSize());

    var employeeTerritoryJPAQuery = query.from(qEmployeeTerritory)
      .where(predicate)
      .limit(pageable.getPageSize())
      .offset(pageable.getOffset())
      //.orderBy(dept.createdDate.desc())
      ;
    return new PageImpl<>(employeeTerritoryJPAQuery.fetch(), pageable, employeeTerritoryJPAQuery.fetchCount());
  }


}