package com.example.northwindspring.dto.search_dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/*@Builder*/
@Accessors(chain = true)
public class CustomerDemographicSearchDto extends SearchDto{

  private String id;

}
