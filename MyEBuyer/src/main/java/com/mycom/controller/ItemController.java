package com.mycom.controller;


import com.mycom.domain.item.Item;
import com.mycom.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/item")
public class ItemController extends BaseController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/query.json")
    @ResponseBody
    public Page<Item> checkUser(Item queryItem,
                                @RequestParam(required = false, defaultValue = "1") int pageNo,
                                @RequestParam(required = false, defaultValue = "10") int pageSize) throws Exception {
        return itemService.combineQuery(queryItem, pageNo, pageSize);
    }
}
