package com.mycom.dao;

import org.springframework.data.repository.CrudRepository;

import com.mycom.domain.item.Item;

public interface ItemDao extends CrudRepository<Item, Integer> {

}
