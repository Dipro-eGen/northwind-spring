package com.example.northwindspring.service;


import com.example.northwindspring.dto.search_dto.EmployeeSearchDto;
import com.example.northwindspring.entity.Employee;
import com.example.northwindspring.entity.QEmployee;
import com.example.northwindspring.repository.EmployeeRepository;
import com.example.northwindspring.repository.EmployeeRepository;
import com.example.northwindspring.service.predicate.EmployeePredicate;
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
public class EmployeeService {

  private final EntityManager entityManager;
  private final EmployeeRepository employeeRepository;


  public Employee save(Employee employee) {
    return employeeRepository.save(employee);
  }


  public Page<Employee> search(EmployeeSearchDto employeeSearchDto) {
    final QEmployee qEmployee = QEmployee.employee;
    final JPAQuery<Employee> query = new JPAQuery<>(entityManager);

    Predicate predicate = EmployeePredicate.makePredicate(employeeSearchDto);
    Pageable pageable = PageRequest.of(employeeSearchDto.getPage(), employeeSearchDto.getSize());

    var employeeJPAQuery = query.from(qEmployee)
      .where(predicate)
      .limit(pageable.getPageSize())
      .offset(pageable.getOffset())
      //.orderBy(dept.createdDate.desc())
      ;
    return new PageImpl<>(employeeJPAQuery.fetch(), pageable, employeeJPAQuery.fetchCount());
  }


}