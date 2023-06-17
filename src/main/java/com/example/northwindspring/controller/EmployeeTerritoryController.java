package com.example.northwindspring.controller;

import com.example.northwindspring.dto.search_dto.CategorySearchDto;
import com.example.northwindspring.dto.search_dto.EmployeeTerritorySearchDto;
import com.example.northwindspring.entity.Category;
import com.example.northwindspring.entity.EmployeeTerritory;
import com.example.northwindspring.service.CategoryService;
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
@RequestMapping(path = "/employee-territory")
@Slf4j
@AllArgsConstructor
public class EmployeeTerritoryController {


  private final EmployeeTerritoryService employeeTerritoryService;

  @PostMapping()
  public EmployeeTerritory save(@RequestBody EmployeeTerritory employeeTerritory) {
    return employeeTerritoryService.save(employeeTerritory);
  }

  @PostMapping("/search")
  public ResponseEntity<Page<EmployeeTerritory>> search(@RequestBody EmployeeTerritorySearchDto employeeTerritorySearchDto) {
    return new ResponseEntity(employeeTerritoryService.search(employeeTerritorySearchDto), HttpStatus.OK);
  }
}