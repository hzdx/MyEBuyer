package com.mycom.domain;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
  @Id
  private int id;
  private String name;
  private String password;
  private Date birthday;
  private String phone;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public User() {}

  public User(int id, String name, String password, Date birthday) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.birthday = birthday;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + name + ", password=" + password + ", birthday="
        + birthday + "]";
  }


}
