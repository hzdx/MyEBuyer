package com.mycom.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;

import com.mycom.domain.Item;


public interface ItemDao extends CrudRepository<Item, String> {
    Page<Item> findAll(Specification<Item> spec, Pageable page);
    //组合查询和分页


}
