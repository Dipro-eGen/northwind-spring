package com.example.northwindspring.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "territory")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Territory {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  @Column(name = "description", nullable = false)
  private String description;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "region_id")
  private Region region;

  @Column(name = "region_id", insertable = false, updatable = false)
  private String regionId;

  @OneToMany(mappedBy = "territory", fetch = FetchType.LAZY)
  private List<EmployeeTerritory> employeeTerritoryList;


  public Territory(String id) {
    this.id = id;
  }


}
