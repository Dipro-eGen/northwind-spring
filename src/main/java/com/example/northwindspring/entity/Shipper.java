package com.example.northwindspring.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "shipper")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Shipper {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  @Column(name = "company_name", nullable = false)
  private String companyName;

  @Column(name = "phone", nullable = false)
  private String phone;

  @OneToMany(mappedBy = "shipper", fetch = FetchType.LAZY)
  private List<OrderInfo> orderInfoList;


  public Shipper(String id) {
    this.id = id;
  }


}
