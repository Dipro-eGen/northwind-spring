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
@Table(name = "order_info")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class OrderInfo {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

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

  @Column(name = "shipped_via")
  private String shippedVia;

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

  @OneToMany(mappedBy = "orderInfo", fetch = FetchType.LAZY)
  private List<OrderInfoDetail> orderInfoDetailList;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "employee_id")
  private Employee employee;

  @Column(name = "employee_id", insertable = false, updatable = false)
  private String employeeId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @Column(name = "customer_id", insertable = false, updatable = false)
  private String customerId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "shipper_id")
  private Shipper shipper;

  @Column(name = "shipper_id", insertable = false, updatable = false)
  private String shipperId;


  public OrderInfo(String id) {
    this.id = id;
  }


}
