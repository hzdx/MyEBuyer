package com.mycom.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {
  @Id
  @GenericGenerator(name = "idGenerator", strategy = "uuid")
  @GeneratedValue(generator = "idGenerator")
  private String id;
  private String name;
  private Double price;
  private String descri;

  @Transient
  @JsonIgnore
  private Double floorPrice;//最低、高价，用于查询
  @Transient
  @JsonIgnore
  private Double peakPrice;

  public Item() {}

  public Item(String name, Double price, String descri) {
    this.name = name;
    this.price = price;
    this.descri = descri;
  }

  @Override
  public String toString() {
    return "Item [id=" + id + ", name=" + name + ", price=" + price + ", descri=" + descri + "]";
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getDescri() {
    return descri;
  }

  public void setDescri(String descri) {
    this.descri = descri;
  }

  public Double getFloorPrice() {
    return floorPrice;
  }

  public void setFloorPrice(Double floorPrice) {
    this.floorPrice = floorPrice;
  }

  public Double getPeakPrice() {
    return peakPrice;
  }

  public void setPeakPrice(Double peakPrice) {
    this.peakPrice = peakPrice;
  }
}
