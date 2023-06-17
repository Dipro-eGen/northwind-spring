package com.example.northwindspring.controller;

import com.example.northwindspring.dto.search_dto.EmployeeSearchDto;
import com.example.northwindspring.dto.search_dto.EmployeeTerritorySearchDto;
import com.example.northwindspring.entity.Employee;
import com.example.northwindspring.entity.EmployeeTerritory;
import com.example.northwindspring.service.EmployeeService;
import com.example.northwindspring.service.EmployeeTerritoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employee")
@Slf4j
@AllArgsConstructor
public class EmployeeController {


  private final EmployeeService employeeService;

  @PostMapping()
  public Employee save(@RequestBody Employee employee) {
    return employeeService.save(employee);
  }

  @PostMapping("/search")
  public ResponseEntity<Page<Employee>> search(@RequestBody EmployeeSearchDto employeeSearchDto) {
    return new ResponseEntity(employeeService.search(employeeSearchDto), HttpStatus.OK);
  }
}