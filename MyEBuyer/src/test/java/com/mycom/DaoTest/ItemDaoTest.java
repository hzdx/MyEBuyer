package com.mycom.DaoTest;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycom.dao.ItemDao;
import com.mycom.dao.UserDao;
import com.mycom.domain.item.Item;

public class ItemDaoTest {
  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
  ItemDao itemDao = context.getBean(ItemDao.class);
  
  @Test
  public void testSave(){
    Item item = new Item("aaa","javaDevelop",20.9,"good book");
    Item item2 = new Item("aaa","php",20.9,"good book");
    Item item3 = new Item("aaa",".net",20.9,"good book");
    itemDao.save(item2);
    itemDao.save(item3);
  }

}
