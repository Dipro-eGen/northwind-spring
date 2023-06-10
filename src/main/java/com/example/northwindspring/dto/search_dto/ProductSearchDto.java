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
public class ProductSearchDto extends SearchDto{

  private String id;

}
