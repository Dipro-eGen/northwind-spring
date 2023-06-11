package com.example.northwindspring.service;


import com.example.northwindspring.dto.search_dto.RegionSearchDto;
import com.example.northwindspring.entity.QRegion;
import com.example.northwindspring.entity.Region;
import com.example.northwindspring.repository.RegionRepository;
import com.example.northwindspring.service.predicate.RegionPredicate;
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
public class RegionService {

  private final EntityManager entityManager;
  private final RegionRepository regionRepository;


  public Region save(Region region) {
    return regionRepository.save(region);
  }


  public Page<Region> search(RegionSearchDto regionSearchDto) {
    final QRegion qRegion = QRegion.region;
    final JPAQuery<Region> query = new JPAQuery<>(entityManager);

    Predicate predicate = RegionPredicate.makePredicate(regionSearchDto);
    Pageable pageable = PageRequest.of(regionSearchDto.getPage(), regionSearchDto.getSize());

    var regionJPAQuery = query.from(qRegion)
      .where(predicate)
      .limit(pageable.getPageSize())
      .offset(pageable.getOffset())
      //.orderBy(dept.createdDate.desc())
      ;
    return new PageImpl<>(regionJPAQuery.fetch(), pageable, regionJPAQuery.fetchCount());
  }


}