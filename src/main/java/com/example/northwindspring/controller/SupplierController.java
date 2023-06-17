package com.example.northwindspring.controller;

import com.example.northwindspring.dto.search_dto.RegionSearchDto;
import com.example.northwindspring.dto.search_dto.SupplierSearchDto;
import com.example.northwindspring.entity.Region;
import com.example.northwindspring.entity.Supplier;
import com.example.northwindspring.service.RegionService;
import com.example.northwindspring.service.SupplierService;
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
@RequestMapping(path = "/supplier")
@Slf4j
@AllArgsConstructor
public class SupplierController {


  private final SupplierService supplierService;

  @PostMapping()
  public Supplier save(@RequestBody Supplier supplier) {
    return supplierService.save(supplier);
  }

  @PostMapping("/search")
  public ResponseEntity<Page<Supplier>> search(@RequestBody SupplierSearchDto supplierSearchDto) {
    return new ResponseEntity(supplierService.search(supplierSearchDto), HttpStatus.OK);
  }
}