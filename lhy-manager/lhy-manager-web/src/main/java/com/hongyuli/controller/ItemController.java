package com.hongyuli.controller;

import com.hongyuli.common.pojo.EUDataGridResult;
import com.hongyuli.common.pojo.TaotaoResult;
import com.hongyuli.pojo.TbItem;
import com.hongyuli.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @创建人 李弘昱
 * @创建时间 2018/6/29
 * @描述
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getTbItemById(@PathVariable Long itemId){
        return itemService.getTbItemById(itemId);
    }

    @RequestMapping("/item/list")
    @ResponseBody
    public EUDataGridResult getTbItemList(int page, int rows){
        return itemService.getTbItemList(page,rows);
    }

    @RequestMapping(value="/item/save", method=RequestMethod.POST)
    @ResponseBody
    private TaotaoResult createItem(TbItem item, String desc, String itemParams) throws Exception {
        TaotaoResult result = itemService.createItem(item, desc, itemParams);
        return result;
    }
}
