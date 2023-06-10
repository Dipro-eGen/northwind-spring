package com.example.northwindspring.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "demographic")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Demographic {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  @Column(name = "description", nullable = false)
  private String description;

  @OneToMany(mappedBy = "demographic", fetch = FetchType.LAZY)
  private List<CustomerDemographic> customerDemographicList;


  public Demographic(String id) {
    this.id = id;
  }


}
