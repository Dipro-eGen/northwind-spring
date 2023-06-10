package com.example.northwindspring.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "product")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Product {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "quantity_per_unit")
  private String quantityPerUnit;

  @Column(name = "unit_price")
  private String unitPrice;

  @Column(name = "unit_in_stock")
  private Integer unitInStock;

  @Column(name = "unit_in_order")
  private Integer unitInOrder;

  @Column(name = "re_order_label")
  private Integer reOrderLabel;

  @Column(name = "discontinued")
  private Boolean discontinued;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id")
  private Category category;

  @Column(name = "category_id", insertable = false, updatable = false)
  private String categoryId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "supplier_id")
  private Supplier supplier;

  @Column(name = "supplier_id", insertable = false, updatable = false)
  private String supplierId;

  @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
  private List<OrderDetail> orderDetailList;

  public Product(String id) {
    this.id = id;
  }


}
