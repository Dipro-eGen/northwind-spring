package com.example.northwindspring.controller;

import com.example.northwindspring.dto.search_dto.EmployeeTerritorySearchDto;
import com.example.northwindspring.dto.search_dto.TerritorySearchDto;
import com.example.northwindspring.entity.EmployeeTerritory;
import com.example.northwindspring.entity.Territory;
import com.example.northwindspring.service.EmployeeTerritoryService;
import com.example.northwindspring.service.TerritoryService;
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
@RequestMapping(path = "/territory")
@Slf4j
@AllArgsConstructor
public class TerritoryController {


  private final TerritoryService territoryService;

  @PostMapping()
  public Territory save(@RequestBody Territory territory) {
    return territoryService.save(territory);
  }

  @PostMapping("/search")
  public ResponseEntity<Page<Territory>> search(@RequestBody TerritorySearchDto territorySearchDto) {
    return new ResponseEntity(territoryService.search(territorySearchDto), HttpStatus.OK);
  }
}