package com.example.northwindspring.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "customer")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Customer {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  @Column(name = "company_name", nullable = false)
  private String companyName;

  @Column(name = "contract_name")
  private String contractName;

  @Column(name = "contract_title")
  private String contractTitle;

  @Column(name = "city")
  private String city;

  @Column(name = "address")
  private String address;

  @Column(name = "region")
  private String region;

  @Column(name = "postal_code")
  private String postalCode;

  @Column(name = "country")
  private String country;

  @Column(name = "phone")
  private String phone;

  @Column(name = "fax")
  private String fax;

  @Column(name = "home_page")
  private String homePage;

  @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
  private List<Order> orderList;

  @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
  private List<CustomerDemographic> customerDemographicList;




  public Customer(String id) {
    this.id = id;
  }


}
