package com.mycom.ServiceTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycom.domain.User;
import com.mycom.domain.item.Item;
import com.mycom.service.ItemService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycom.dao.UserDao;
import com.mycom.service.UserService;
import org.springframework.data.domain.Page;

import java.util.List;

public class UserServiceTest {
  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
      "spring/spring-dao.xml");
  UserDao userDao = context.getBean(UserDao.class);
  UserService userService = context.getBean(UserService.class);
  ItemService itemService = context.getBean(ItemService.class);

  @Test
  public void testSave() {
    User user = new User();
    user.setName("xiaom");
    user.setPassword("1234");
    userDao.save(user);
  }

  @Test
  public void testItemCombineQuery()throws Exception{
    Item item = new Item();
    item.setName("c");
    item.setFloorPrice(10d);
    item.setPeakPrice(60d);
    Page<Item> list = itemService.combineQuery(item,9,5);
    //for(Item it:list) System.out.println(it);
    String json = new ObjectMapper().writeValueAsString(list);
    System.out.println("============json: " + json);
  }

}
