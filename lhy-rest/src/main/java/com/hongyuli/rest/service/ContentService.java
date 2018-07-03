package com.hongyuli.rest.service;

import java.util.List;

import com.hongyuli.pojo.TbContent;

public interface ContentService {

	List<TbContent> getContentList(long contentCid);
}
