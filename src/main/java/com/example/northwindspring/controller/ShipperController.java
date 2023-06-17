package com.example.northwindspring.controller;

import com.example.northwindspring.dto.search_dto.RegionSearchDto;
import com.example.northwindspring.dto.search_dto.ShipperSearchDto;
import com.example.northwindspring.entity.Region;
import com.example.northwindspring.entity.Shipper;
import com.example.northwindspring.service.RegionService;
import com.example.northwindspring.service.ShipperService;
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
@RequestMapping(path = "/shipper")
@Slf4j
@AllArgsConstructor
public class ShipperController {


  private final ShipperService shipperService;

  @PostMapping()
  public Shipper save(@RequestBody Shipper shipper) {
    return shipperService.save(shipper);
  }

  @PostMapping("/search")
  public ResponseEntity<Page<Shipper>> search(@RequestBody ShipperSearchDto shipperSearchDto) {
    return new ResponseEntity(shipperService.search(shipperSearchDto), HttpStatus.OK);
  }
}