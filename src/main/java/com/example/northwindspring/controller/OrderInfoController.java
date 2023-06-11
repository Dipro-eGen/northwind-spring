package com.example.northwindspring.controller;

import com.example.northwindspring.dto.search_dto.OrderInfoSearchDto;
import com.example.northwindspring.dto.search_dto.ProductSearchDto;
import com.example.northwindspring.entity.OrderInfo;
import com.example.northwindspring.entity.Product;
import com.example.northwindspring.service.OrderInfoService;
import com.example.northwindspring.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/order-info")
@Slf4j
@AllArgsConstructor
public class OrderInfoController {


  private final OrderInfoService orderInfoService;

  @PostMapping()
  public OrderInfo save(@RequestBody OrderInfo orderInfo) {
    return orderInfoService.save(orderInfo);
  }

  @PostMapping("/search")
  public ResponseEntity<?> search(@RequestBody OrderInfoSearchDto orderInfoSearchDto) {
    return new ResponseEntity(orderInfoService.search(orderInfoSearchDto), HttpStatus.OK);
  }
}