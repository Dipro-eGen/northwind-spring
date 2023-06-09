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
@Table(name = "order")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Order {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "order_id",insertable = false,updatable = false)
  private Integer orderId;

  @Column(name = "customer_id",insertable = false,updatable = false)
  private Integer customerId;

  @Column(name = "order_date")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime orderDate;

  @Column(name = "required_date")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime requiredDate;

  @Column(name = "shipped_date")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime shippedDate;

  @Column(name = "ship_via")
  private String shipVia;

  @Column(name = "freight")
  private String freight;

  @Column(name = "ship_name")
  private String shipName;

  @Column(name = "ship_address")
  private String shipAddress;

  @Column(name = "ship_city")
  private String shipCity;

  @Column(name = "ship_region")
  private String shipRegion;

  @Column(name = "ship_postal_code")
  private String shipPostalCode;

  @Column(name = "ship_country")
  private String shipCountry;

  @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
  private List<OrderDetail> orderDetailList;

  public Order(String id) {
    this.id = id;
  }

}
