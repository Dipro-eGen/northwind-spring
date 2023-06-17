package com.example.northwindspring.controller;

import com.example.northwindspring.dto.search_dto.CategorySearchDto;
import com.example.northwindspring.dto.search_dto.RegionSearchDto;
import com.example.northwindspring.entity.Category;
import com.example.northwindspring.entity.Region;
import com.example.northwindspring.service.CategoryService;
import com.example.northwindspring.service.RegionService;
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
@RequestMapping(path = "/region")
@Slf4j
@AllArgsConstructor
public class RegionController {


  private final RegionService regionService;

  @PostMapping()
  public Region save(@RequestBody Region region) {
    return regionService.save(region);
  }

  @PostMapping("/search")
  public ResponseEntity<Page<Region>> search(@RequestBody RegionSearchDto regionSearchDto) {
    return new ResponseEntity(regionService.search(regionSearchDto), HttpStatus.OK);
  }
}