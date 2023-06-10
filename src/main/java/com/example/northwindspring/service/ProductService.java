package com.example.northwindspring.service;


import com.example.northwindspring.dto.search_dto.ProductSearchDto;
import com.example.northwindspring.entity.Product;
import com.example.northwindspring.entity.QProduct;
import com.example.northwindspring.repository.ProductRepository;
import com.example.northwindspring.service.predicate.ProductPredicate;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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


  public Page<Product> search(ProductSearchDto productSearchDto) {
    final QProduct qProduct = QProduct.product;
    final JPAQuery<Product> query = new JPAQuery<>(entityManager);

    Predicate predicate = ProductPredicate.makePredicate(productSearchDto);
    Pageable pageable = PageRequest.of(productSearchDto.getPage(), productSearchDto.getSize());

    var productJPAQuery = query.from(qProduct)
      .where(predicate)
      .limit(pageable.getPageSize())
      .offset(pageable.getOffset())
      //.orderBy(dept.createdDate.desc())
      ;
    return new PageImpl<>(productJPAQuery.fetch(), pageable, productJPAQuery.fetchCount());
  }


}