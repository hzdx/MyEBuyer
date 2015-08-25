package com.mycom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.dao.UserDao;
import com.mycom.domain.User;

@Service
public class UserService {
  @Autowired
  private UserDao userDao;

  public User save(User user) {
    return userDao.save(user);
  }

  public User login(String name, String psw) {
    List<User> list = userDao.findUserByNameAndPsw(name, psw);
    if (list.size() > 0) {
      return list.get(0);
    } else {
      return null;
    }
  }

  public User checkName(String name) {
    List<User> list = userDao.findUserByName(name);
    if (list.size() > 0) {
      return list.get(0);
    } else {
      return null;
    }
  }

}
