package com.hongyuli.service;

import java.util.List;

import com.hongyuli.common.pojo.EUTreeNode;

public interface ItemCatService {

	List<EUTreeNode> getCatList(long parentId);
}
