package com.hongyuli.service;

import java.util.List;

import com.hongyuli.common.pojo.EUTreeNode;
import com.hongyuli.common.pojo.TaotaoResult;

public interface ContentCategoryService {

	List<EUTreeNode> getCategoryList(long parentId);
	TaotaoResult insertContentCategory(long parentId, String name);
}
