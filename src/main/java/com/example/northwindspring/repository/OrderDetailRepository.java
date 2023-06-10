package com.example.northwindspring.repository;


import com.example.northwindspring.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository
  extends JpaRepository<OrderDetail, String>, QuerydslPredicateExecutor<OrderDetail> {

}
