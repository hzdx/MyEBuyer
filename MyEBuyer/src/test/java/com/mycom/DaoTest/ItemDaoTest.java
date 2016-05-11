package com.mycom.DaoTest;

import com.mycom.dao.ItemDao;
import com.mycom.domain.item.Item;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class ItemDaoTest {
  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
      "spring/spring-dao.xml");
  ItemDao itemDao = context.getBean(ItemDao.class);

  @Test
  public void testSave() {
//    Item item = new Item("c#", 100d, "good book");
//    item.setFloorPrice(50d);
//    Item item2 = new Item("c++", 10.9, "good book");
//    Item item3 = new Item("java", 12.9, "good book");
    for(int i=0;i<50;i++) {
      Item item = new Item("c"+i, 20d+i, "good book");
      itemDao.save(item);
    }
    //itemDao.save(item3);
    //Arrays.
  }

}
