package com.example.northwindspring.controller;

import com.example.northwindspring.dto.search_dto.CustomerDemographicSearchDto;
import com.example.northwindspring.entity.CustomerDemographic;
import com.example.northwindspring.service.CustomerDemographicService;
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
@RequestMapping(path = "/customer-demographic")
@Slf4j
@AllArgsConstructor
public class CustomerDemographicController {


  private final CustomerDemographicService customerDemographicService;

  @PostMapping()
  public CustomerDemographic save(@RequestBody CustomerDemographic customerDemographic) {
    return customerDemographicService.save(customerDemographic);
  }

  @PostMapping("/search")
  public ResponseEntity<Page<CustomerDemographic>> search(@RequestBody CustomerDemographicSearchDto customerDemographicSearchDto) {
    return new ResponseEntity(customerDemographicService.search(customerDemographicSearchDto), HttpStatus.OK);
  }
}