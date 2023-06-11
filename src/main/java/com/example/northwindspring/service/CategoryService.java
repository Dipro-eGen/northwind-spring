package com.example.northwindspring.service;


import com.example.northwindspring.dto.search_dto.CategorySearchDto;
import com.example.northwindspring.dto.search_dto.ProductSearchDto;
import com.example.northwindspring.entity.Category;
import com.example.northwindspring.entity.Category;
import com.example.northwindspring.entity.QCategory;
import com.example.northwindspring.entity.QProduct;
import com.example.northwindspring.repository.CategoryRepository;
import com.example.northwindspring.repository.ProductRepository;
import com.example.northwindspring.service.predicate.CategoryPredicate;
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
public class CategoryService {

  private final EntityManager entityManager;
  private final CategoryRepository categoryRepository;


  public Category save(Category category) {
    return categoryRepository.save(category);
  }


  public Page<Category> search(CategorySearchDto categorySearchDto) {
    final QCategory qCategory = QCategory.category;
    final JPAQuery<Category> query = new JPAQuery<>(entityManager);

    Predicate predicate = CategoryPredicate.makePredicate(categorySearchDto);
    Pageable pageable = PageRequest.of(categorySearchDto.getPage(), categorySearchDto.getSize());

    var categoryJPAQuery = query.from(qCategory)
      .where(predicate)
      .limit(pageable.getPageSize())
      .offset(pageable.getOffset())
      //.orderBy(dept.createdDate.desc())
      ;
    return new PageImpl<>(categoryJPAQuery.fetch(), pageable, categoryJPAQuery.fetchCount());
  }


}