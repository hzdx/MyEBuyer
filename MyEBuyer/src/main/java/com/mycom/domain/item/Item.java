package com.mycom.domain.item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="item")
public class Item {
  @Id
  @GenericGenerator(name="idGenerator", strategy="uuid")  
  @GeneratedValue(generator="idGenerator")
  private String id;
  private String name;
  private Double price;
  private String descri;
  public Item(){}
  public Item(String id, String name, Double price, String descri) {
    super();
    this.id = id;
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
  

}
