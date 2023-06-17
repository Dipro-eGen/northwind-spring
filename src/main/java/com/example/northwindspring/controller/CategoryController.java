package com.example.northwindspring.controller;

import com.example.northwindspring.dto.search_dto.CategorySearchDto;
import com.example.northwindspring.dto.search_dto.ProductSearchDto;
import com.example.northwindspring.entity.Category;
import com.example.northwindspring.entity.Product;
import com.example.northwindspring.service.CategoryService;
import com.example.northwindspring.service.ProductService;
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
@RequestMapping(path = "/category")
@Slf4j
@AllArgsConstructor
public class CategoryController {


  private final CategoryService categoryService;

  @PostMapping()
  public Category save(@RequestBody Category category) {
    return categoryService.save(category);
  }

  @PostMapping("/search")
  public ResponseEntity<Page<Category>> search(@RequestBody CategorySearchDto categorySearchDto) {
    return new ResponseEntity(categoryService.search(categorySearchDto), HttpStatus.OK);
  }
}