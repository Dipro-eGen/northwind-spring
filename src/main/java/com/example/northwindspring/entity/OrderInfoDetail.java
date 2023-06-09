package com.example.northwindspring.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "order_info_detail")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class OrderInfoDetail {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  @Column(name = "unit_price", nullable = false)
  private String unitPrice;

  @Column(name = "quantity")
  private Integer quantity;

  @Column(name = "discount")
  private String discount;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_info_id")
  private OrderInfo orderInfo;

  @Column(name = "order_info_id", insertable = false, updatable = false)
  private String orderInfoId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
  private Product product;

  @Column(name = "product_id", insertable = false, updatable = false)
  private String productId;

  public OrderInfoDetail(String id) {
    this.id = id;
  }


}
