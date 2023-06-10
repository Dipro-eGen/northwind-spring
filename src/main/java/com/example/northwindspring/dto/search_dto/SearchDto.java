package com.example.northwindspring.dto.search_dto;


import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/*@Builder*/
@Accessors(chain = true)
public class SearchDto {

  private String id;
  private String idNotEqual;
  private String name;
  private String nameIgnoreCase;
  private String nameContain;

  private String multiSearchProp;

  private List<String> idList;
  private List<String> idNotEqualList;


  private Integer page;
  private Integer size;

}
