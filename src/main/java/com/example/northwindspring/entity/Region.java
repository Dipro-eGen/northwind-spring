package com.example.northwindspring.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "region")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Region {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  @Column(name = "description", nullable = false)
  private String description;

  @OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
  private List<Territory> territoryList;


  public Region(String id) {
    this.id = id;
  }


}
