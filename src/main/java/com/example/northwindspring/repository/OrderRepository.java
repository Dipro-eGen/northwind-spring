package com.example.northwindspring.repository;


import com.example.northwindspring.entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository
  extends JpaRepository<OrderInfo, String>, QuerydslPredicateExecutor<OrderInfo> {

}
