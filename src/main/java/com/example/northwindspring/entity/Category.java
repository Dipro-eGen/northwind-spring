package com.example.northwindspring.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "category")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Category {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "image_id")
  private String imageId;

  @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
  private List<Product> productList;


  public Category(String id) {
    this.id = id;
  }


}
