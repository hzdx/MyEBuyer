package com.mycom.ServiceTest;

import com.mycom.domain.User;
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
  public void testSave() {
    User user = new User();
    user.setName("xiaom");
    user.setPassword("1234");
    userDao.save(user);
  }

}
