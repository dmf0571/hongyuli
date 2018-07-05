package com.hongyuli.order.service;

import java.util.List;

import com.hongyuli.common.pojo.TaotaoResult;
import com.hongyuli.pojo.TbOrder;
import com.hongyuli.pojo.TbOrderItem;
import com.hongyuli.pojo.TbOrderShipping;

public interface OrderService {

	TaotaoResult createOrder(TbOrder order, List<TbOrderItem> itemList, TbOrderShipping orderShipping);
}
