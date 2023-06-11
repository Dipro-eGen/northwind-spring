package com.example.northwindspring.service;


import com.example.northwindspring.dto.search_dto.ProductSearchDto;
import com.example.northwindspring.dto.search_dto.ShipperSearchDto;
import com.example.northwindspring.entity.Product;
import com.example.northwindspring.entity.QProduct;
import com.example.northwindspring.entity.QShipper;
import com.example.northwindspring.entity.Shipper;
import com.example.northwindspring.repository.ProductRepository;
import com.example.northwindspring.repository.ShipperRepository;
import com.example.northwindspring.service.predicate.ProductPredicate;
import com.example.northwindspring.service.predicate.ShipperPredicate;
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
public class ShipperService {

  private final EntityManager entityManager;
  private final ShipperRepository shipperRepository;


  public Shipper save(Shipper shipper) {
    return shipperRepository.save(shipper);
  }


  public Page<Shipper> search(ShipperSearchDto shipperSearchDto) {
    final QShipper qShipper = QShipper.shipper;
    final JPAQuery<Shipper> query = new JPAQuery<>(entityManager);

    Predicate predicate = ShipperPredicate.makePredicate(shipperSearchDto);
    Pageable pageable = PageRequest.of(shipperSearchDto.getPage(), shipperSearchDto.getSize());

    var shipperJPAQuery = query.from(qShipper)
      .where(predicate)
      .limit(pageable.getPageSize())
      .offset(pageable.getOffset())
      //.orderBy(dept.createdDate.desc())
      ;
    return new PageImpl<>(shipperJPAQuery.fetch(), pageable, shipperJPAQuery.fetchCount());
  }


}