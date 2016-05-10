package com.mycom.dao;

import com.mycom.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<User, Integer> {

    List<User> findByNameAndPassword(String name, String password);

    List<User> findByName(String name);
}
