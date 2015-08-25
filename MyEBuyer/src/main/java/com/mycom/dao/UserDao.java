package com.mycom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mycom.domain.User;

public interface UserDao extends CrudRepository<User, Integer> {

  @Query("SELECT u FROM User u WHERE u.name=?1 AND u.password = ?2")
  public List<User> findUserByNameAndPsw(String name, String password);

  @Query("SELECT u FROM User u WHERE u.name=?1")
  public List<User> findUserByName(String name);
}
