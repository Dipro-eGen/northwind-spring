package com.example.northwindspring.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "customer_demographic")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class CustomerDemographic {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @Column(name = "employee_id", insertable = false, updatable = false)
  private String customerId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "demographic_id")
  private Demographic demographic;

  @Column(name = "demographic_id", insertable = false, updatable = false)
  private String demographicId;


  public CustomerDemographic(String id) {
    this.id = id;
  }


}
