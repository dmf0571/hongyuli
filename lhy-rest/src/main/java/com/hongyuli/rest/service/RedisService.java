package com.hongyuli.rest.service;

import com.hongyuli.common.pojo.TaotaoResult;

public interface RedisService {

	TaotaoResult syncContent(long contentCid);
}
