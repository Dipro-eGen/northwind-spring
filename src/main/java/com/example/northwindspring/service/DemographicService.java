package com.example.northwindspring.service;


import com.example.northwindspring.dto.search_dto.DemographicSearchDto;
import com.example.northwindspring.entity.Demographic;
import com.example.northwindspring.entity.QDemographic;
import com.example.northwindspring.repository.DemographicRepository;
import com.example.northwindspring.service.predicate.DemographicPredicate;
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
public class DemographicService {

  private final EntityManager entityManager;
  private final DemographicRepository demographicRepository;


  public Demographic save(Demographic demographic) {
    return demographicRepository.save(demographic);
  }


  public Page<Demographic> search(DemographicSearchDto demographicSearchDto) {
    final QDemographic qDemographic = QDemographic.demographic;
    final JPAQuery<Demographic> query = new JPAQuery<>(entityManager);

    Predicate predicate = DemographicPredicate.makePredicate(demographicSearchDto);
    Pageable pageable = PageRequest.of(demographicSearchDto.getPage(), demographicSearchDto.getSize());

    var demographicJPAQuery = query.from(qDemographic)
      .where(predicate)
      .limit(pageable.getPageSize())
      .offset(pageable.getOffset())
      //.orderBy(dept.createdDate.desc())
      ;
    return new PageImpl<>(demographicJPAQuery.fetch(), pageable, demographicJPAQuery.fetchCount());
  }


}