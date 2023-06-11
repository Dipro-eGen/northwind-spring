package com.example.northwindspring.controller;

import com.example.northwindspring.dto.search_dto.OrderInfoDetailSearchDto;
import com.example.northwindspring.dto.search_dto.OrderInfoSearchDto;
import com.example.northwindspring.entity.OrderInfo;
import com.example.northwindspring.entity.OrderInfoDetail;
import com.example.northwindspring.service.OrderInfoDetailService;
import com.example.northwindspring.service.OrderInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/order-info-detail")
@Slf4j
@AllArgsConstructor
public class OrderInfoDetailController {


  private final OrderInfoDetailService orderInfoDetailService;

  @PostMapping()
  public OrderInfoDetail save(@RequestBody OrderInfoDetail orderInfoDetail) {
    return orderInfoDetailService.save(orderInfoDetail);
  }

  @PostMapping("/search")
  public ResponseEntity<?> search(@RequestBody OrderInfoDetailSearchDto orderInfoDetailSearchDto) {
    return new ResponseEntity(orderInfoDetailService.search(orderInfoDetailSearchDto), HttpStatus.OK);
  }
}