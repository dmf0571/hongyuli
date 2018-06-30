package com.hongyuli.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hongyuli.common.pojo.EUDataGridResult;
import com.hongyuli.common.pojo.TaotaoResult;
import com.hongyuli.common.utils.IDUtils;
import com.hongyuli.mapper.TbItemDescMapper;
import com.hongyuli.mapper.TbItemMapper;
import com.hongyuli.mapper.TbItemParamItemMapper;
import com.hongyuli.pojo.TbItem;
import com.hongyuli.pojo.TbItemDesc;
import com.hongyuli.pojo.TbItemExample;
import com.hongyuli.pojo.TbItemParamItem;
import com.hongyuli.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @创建人 李弘昱
 * @创建时间 2018/6/29
 * @描述
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;

    @Autowired
    private TbItemDescMapper itemDescMapper;

    @Autowired
    private TbItemParamItemMapper itemParamItemMapper;
    /**

     *@描述

     *@参数  [ItemId]

     *@返回值  TbItem

     *@创建人  chenjie

     *@创建时间  2018/6/29

     *@修改人和其它信息

     */
    @Override
    public TbItem getTbItemById(Long itemId){

        TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
        return tbItem;

    }

    @Override
    public EUDataGridResult getTbItemList(int page, int rows){
        TbItemExample example = new TbItemExample();
        PageHelper.startPage(page,rows);
        List<TbItem> list = itemMapper.selectByExample(example);
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(list);
        PageInfo pageInfo = new PageInfo(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public TaotaoResult createItem(TbItem item, String desc, String itemParam) throws Exception {
        //item补全
        //生成商品ID
        Long itemId = IDUtils.genItemId();
        item.setId(itemId);
        // '商品状态，1-正常，2-下架，3-删除',
        item.setStatus((byte) 1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        //插入到数据库
        itemMapper.insert(item);
        //添加商品描述信息
        TaotaoResult result = insertItemDesc(itemId, desc);
        if (result.getStatus() != 200) {
            throw new Exception();
        }
        //添加规格参数
        result = insertItemParamItem(itemId, itemParam);
        if (result.getStatus() != 200) {
            throw new Exception();
        }
        return TaotaoResult.ok();
    }
    /**
     * 添加商品描述
     * <p>Title: insertItemDesc</p>
     * <p>Description: </p>
     * @param desc
     */
    private TaotaoResult insertItemDesc(Long itemId, String desc) {
        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        itemDescMapper.insert(itemDesc);
        return TaotaoResult.ok();
    }

    /**
     * 添加规格参数
     * <p>Title: insertItemParamItem</p>
     * <p>Description: </p>
     * @param itemId
     * @param itemParam
     * @return
     */
    private TaotaoResult insertItemParamItem(Long itemId, String itemParam) {
        //创建一个pojo
        TbItemParamItem itemParamItem = new TbItemParamItem();
        itemParamItem.setItemId(itemId);
        itemParamItem.setParamData(itemParam);
        itemParamItem.setCreated(new Date());
        itemParamItem.setUpdated(new Date());
        //向表中插入数据
        itemParamItemMapper.insert(itemParamItem);

        return TaotaoResult.ok();

    }
}
