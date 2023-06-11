package com.example.northwindspring.service;


import com.example.northwindspring.dto.search_dto.TerritorySearchDto;
import com.example.northwindspring.entity.Territory;
import com.example.northwindspring.entity.QTerritory;
import com.example.northwindspring.repository.TerritoryRepository;
import com.example.northwindspring.repository.TerritoryRepository;
import com.example.northwindspring.service.predicate.TerritoryPredicate;
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
public class TerritoryService {

  private final EntityManager entityManager;
  private final TerritoryRepository territoryRepository;


  public Territory save(Territory territory) {
    return territoryRepository.save(territory);
  }


  public Page<Territory> search(TerritorySearchDto territorySearchDto) {
    final QTerritory qTerritory = QTerritory.territory;
    final JPAQuery<Territory> query = new JPAQuery<>(entityManager);

    Predicate predicate = TerritoryPredicate.makePredicate(territorySearchDto);
    Pageable pageable = PageRequest.of(territorySearchDto.getPage(), territorySearchDto.getSize());

    var territoryJPAQuery = query.from(qTerritory)
      .where(predicate)
      .limit(pageable.getPageSize())
      .offset(pageable.getOffset())
      //.orderBy(dept.createdDate.desc())
      ;
    return new PageImpl<>(territoryJPAQuery.fetch(), pageable, territoryJPAQuery.fetchCount());
  }


}