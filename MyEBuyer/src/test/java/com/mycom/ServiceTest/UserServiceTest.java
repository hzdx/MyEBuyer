package com.mycom.ServiceTest;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycom.dao.UserDao;
import com.mycom.service.UserService;

public class UserServiceTest {
  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {
      "spring/spring-dao.xml", "spring/spring-tx.xml"});
  UserDao userDao = context.getBean(UserDao.class);
  UserService userService = context.getBean(UserService.class);

  @Test
  public void testSave() {}

}
