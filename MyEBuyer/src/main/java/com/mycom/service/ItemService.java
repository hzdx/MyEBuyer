package com.mycom.service;

import com.mycom.dao.ItemDao;
import com.mycom.domain.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemDao itemDao;

    public Page<Item> combineQuery(final Item item, int pageNo, int pageSize) throws Exception {
        List<Item> list = null;
        Specification<Item> spec = new Specification<Item>() {
            public Predicate toPredicate(Root<Item> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> pres = new ArrayList<Predicate>();
                if (item.getFloorPrice() != null)
                    pres.add(cb.ge(root.get("price").as(Double.class), item.getFloorPrice()));
                if (item.getPeakPrice() != null)
                    pres.add(cb.le(root.get("price").as(Double.class), item.getPeakPrice()));
                if (item.getName() != null && !item.getName().trim().equals(""))
                    pres.add(cb.like(root.get("name").as(String.class), "%" + item.getName() + "%"));
                Predicate[] p = new Predicate[pres.size()];
                return cb.and(pres.toArray(p));
            }
        };
        Page<Item> page = itemDao.findAll(spec, new PageRequest(pageNo - 1, pageSize));
        // new PageRequest(0, 5, Sort.Direction.DESC,"name"))
        // 5个一页，显示第一页,以name字段降序排列

//        String json = new ObjectMapper().writeValueAsString(page);
//        System.out.println("============json: " + json);
//        list = page.getContent();

        return page;

    }
}


