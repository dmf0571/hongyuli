package com.hongyuli.service;

import com.hongyuli.common.pojo.TaotaoResult;
import com.hongyuli.pojo.TbItemParam;

public interface ItemParamService {

	TaotaoResult getItemParamByCid(long cid);
	TaotaoResult insertItemParam(TbItemParam itemParam);
}
