package com.example.northwindspring.service;


import com.example.northwindspring.dto.search_dto.CustomerSearchDto;
import com.example.northwindspring.entity.Customer;
import com.example.northwindspring.entity.QCustomer;
import com.example.northwindspring.repository.CustomerRepository;
import com.example.northwindspring.repository.CustomerRepository;
import com.example.northwindspring.service.predicate.CustomerPredicate;
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
public class CustomerService {

  private final EntityManager entityManager;
  private final CustomerRepository customerRepository;


  public Customer save(Customer customer) {
    return customerRepository.save(customer);
  }


  public Page<Customer> search(CustomerSearchDto customerSearchDto) {
    final QCustomer qCustomer = QCustomer.customer;
    final JPAQuery<Customer> query = new JPAQuery<>(entityManager);

    Predicate predicate = CustomerPredicate.makePredicate(customerSearchDto);
    Pageable pageable = PageRequest.of(customerSearchDto.getPage(), customerSearchDto.getSize());

    var customerJPAQuery = query.from(qCustomer)
      .where(predicate)
      .limit(pageable.getPageSize())
      .offset(pageable.getOffset())
      //.orderBy(dept.createdDate.desc())
      ;
    return new PageImpl<>(customerJPAQuery.fetch(), pageable, customerJPAQuery.fetchCount());
  }


}