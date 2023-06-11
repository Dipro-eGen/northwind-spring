package com.example.northwindspring.service;


import com.example.northwindspring.dto.search_dto.RegionSearchDto;
import com.example.northwindspring.dto.search_dto.SupplierSearchDto;
import com.example.northwindspring.entity.QRegion;
import com.example.northwindspring.entity.QSupplier;
import com.example.northwindspring.entity.Region;
import com.example.northwindspring.entity.Supplier;
import com.example.northwindspring.repository.RegionRepository;
import com.example.northwindspring.repository.SupplierRepository;
import com.example.northwindspring.service.predicate.RegionPredicate;
import com.example.northwindspring.service.predicate.SupplierPredicate;
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
public class SupplierService {

  private final EntityManager entityManager;
  private final SupplierRepository supplierRepository;


  public Supplier save(Supplier supplier) {
    return supplierRepository.save(supplier);
  }


  public Page<Supplier> search(SupplierSearchDto supplierSearchDto) {
    final QSupplier qSupplier = QSupplier.supplier;
    final JPAQuery<Supplier> query = new JPAQuery<>(entityManager);

    Predicate predicate = SupplierPredicate.makePredicate(supplierSearchDto);
    Pageable pageable = PageRequest.of(supplierSearchDto.getPage(), supplierSearchDto.getSize());

    var supplierJPAQuery = query.from(qSupplier)
      .where(predicate)
      .limit(pageable.getPageSize())
      .offset(pageable.getOffset())
      //.orderBy(dept.createdDate.desc())
      ;
    return new PageImpl<>(supplierJPAQuery.fetch(), pageable, supplierJPAQuery.fetchCount());
  }


}