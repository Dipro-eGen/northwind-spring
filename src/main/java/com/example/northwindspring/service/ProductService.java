package com.example.northwindspring.service;


import com.example.northwindspring.entity.Product;
import com.example.northwindspring.repository.ProductRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

  private final EntityManager entityManager;
 private final ProductRepository productRepository;


  public Product save(Product product) {
    return productRepository.save(product);
  }





}