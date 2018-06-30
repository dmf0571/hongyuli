package com.hongyuli.service;

import com.hongyuli.common.pojo.EUDataGridResult;
import com.hongyuli.common.pojo.TaotaoResult;
import com.hongyuli.pojo.TbItem;

/**
 * @创建人 李弘昱
 * @创建时间 2018/6/29
 * @描述
 */
public interface ItemService {
    TbItem getTbItemById(Long ItemId);

    EUDataGridResult getTbItemList(int page, int rows);

    TaotaoResult createItem(TbItem item, String desc, String itemParam) throws Exception;
}
