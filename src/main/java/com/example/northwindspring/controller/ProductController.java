package com.example.northwindspring.controller;

import com.example.northwindspring.dto.search_dto.ProductSearchDto;
import com.example.northwindspring.entity.Product;
import com.example.northwindspring.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product")
@Slf4j
@AllArgsConstructor
public class ProductController {


  private final ProductService productService;

  @PostMapping()
  public Product save(@RequestBody Product product) {
    return productService.save(product);
  }

  @PostMapping("/search")
  public ResponseEntity<?> search(@RequestBody ProductSearchDto productSearchDto) {
    return new ResponseEntity(productService.search(productSearchDto), HttpStatus.OK);
  }
}