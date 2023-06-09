package com.example.northwindspring.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "order_detail")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class OrderDetail {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  @Column(name = "unit_price", nullable = false)
  private String unitPrice;

  @Column(name = "supplier_id")
  private Integer supplierId;

  @Column(name = "category_id")
  private Integer categoryId;

  @Column(name = "quantity_per_unit")
  private String quantityPerUnit;


/*  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order", nullable = false)
  private Order order;*/



  public OrderDetail(String id) {
    this.id = id;
  }


}
