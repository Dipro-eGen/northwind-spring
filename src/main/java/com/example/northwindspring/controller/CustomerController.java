package com.example.northwindspring.controller;

import com.example.northwindspring.dto.search_dto.CustomerSearchDto;
import com.example.northwindspring.entity.Customer;
import com.example.northwindspring.service.CustomerService;
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
@RequestMapping(path = "/customer")
@Slf4j
@AllArgsConstructor
public class CustomerController {


  private final CustomerService customerService;

  @PostMapping()
  public Customer save(@RequestBody Customer customer) {
    return customerService.save(customer);
  }

  @PostMapping("/search")
  public ResponseEntity<Page<Customer>> search(@RequestBody CustomerSearchDto customerSearchDto) {
    return new ResponseEntity(customerService.search(customerSearchDto), HttpStatus.OK);
  }
}