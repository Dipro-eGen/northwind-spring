package com.example.northwindspring.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "employee_territory")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class EmployeeTerritory {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "employee_id")
  private Employee employee;

  @Column(name = "employee_id", insertable = false, updatable = false)
  private String employeeId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "territory_id")
  private Territory territory;

  @Column(name = "territory_id", insertable = false, updatable = false)
  private String territoryId;




  public EmployeeTerritory(String id) {
    this.id = id;
  }


}
