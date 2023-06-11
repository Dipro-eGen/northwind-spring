package com.example.northwindspring.service;


import com.example.northwindspring.dto.search_dto.CustomerDemographicSearchDto;
import com.example.northwindspring.entity.CustomerDemographic;
import com.example.northwindspring.entity.QCustomerDemographic;
import com.example.northwindspring.repository.CustomerDemographicRepository;
import com.example.northwindspring.service.predicate.CustomerDemographicPredicate;
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
public class CustomerDemographicService {

  private final EntityManager entityManager;
  private final CustomerDemographicRepository customerDemographicRepository;


  public CustomerDemographic save(CustomerDemographic customerDemographic) {
    return customerDemographicRepository.save(customerDemographic);
  }


  public Page<CustomerDemographic> search(CustomerDemographicSearchDto customerDemographicSearchDto) {
    final QCustomerDemographic qCustomerDemographic = QCustomerDemographic.customerDemographic;
    final JPAQuery<CustomerDemographic> query = new JPAQuery<>(entityManager);

    Predicate predicate = CustomerDemographicPredicate.makePredicate(customerDemographicSearchDto);
    Pageable pageable = PageRequest.of(customerDemographicSearchDto.getPage(), customerDemographicSearchDto.getSize());

    var customerDemographicJPAQuery = query.from(qCustomerDemographic)
      .where(predicate)
      .limit(pageable.getPageSize())
      .offset(pageable.getOffset())
      //.orderBy(dept.createdDate.desc())
      ;
    return new PageImpl<>(customerDemographicJPAQuery.fetch(), pageable, customerDemographicJPAQuery.fetchCount());
  }


}