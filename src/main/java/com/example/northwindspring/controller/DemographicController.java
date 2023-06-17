package com.example.northwindspring.controller;

import com.example.northwindspring.dto.search_dto.CustomerDemographicSearchDto;
import com.example.northwindspring.dto.search_dto.DemographicSearchDto;
import com.example.northwindspring.entity.CustomerDemographic;
import com.example.northwindspring.entity.Demographic;
import com.example.northwindspring.service.CustomerDemographicService;
import com.example.northwindspring.service.DemographicService;
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
@RequestMapping(path = "/demographic")
@Slf4j
@AllArgsConstructor
public class DemographicController {


  private final DemographicService demographicService;

  @PostMapping()
  public Demographic save(@RequestBody Demographic demographic) {
    return demographicService.save(demographic);
  }

  @PostMapping("/search")
  public ResponseEntity<Page<Demographic>> search(@RequestBody DemographicSearchDto demographicSearchDto) {
    return new ResponseEntity(demographicService.search(demographicSearchDto), HttpStatus.OK);
  }
}