package com.mycom.DaoTest;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycom.dao.UserDao;
import com.mycom.domain.User;

public class userDaoTest {
  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
  UserDao userDao = context.getBean(UserDao.class);
  
  @Test
  public void testSave(){
    User user = new User("1111", "root", "root", new Date());
    User user1 = new User("2222", "小王", "密码", new Date());
    User user3 = userDao.save(user);
    System.out.println(user3);
    userDao.save(user1);
  }
  
  @Test
  public void testLogin(){
    List<User> list = userDao.findUserByNameAndPsw("小王", "密码");
    System.out.println(list.size());
    for(User user:list){
      System.out.println(user);
    }
  }

}
