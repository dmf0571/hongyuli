package com.hongyuli.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hongyuli.common.pojo.TaotaoResult;
import com.hongyuli.common.utils.ExceptionUtil;
import com.hongyuli.rest.dao.JedisClient;
import com.hongyuli.rest.service.RedisService;

@Service
public class RedisServiceImpl implements RedisService {

	@Autowired
	private JedisClient jedisClient;
	
	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;
	
	@Override
	public TaotaoResult syncContent(long contentCid) {
		try {
			jedisClient.hdel(INDEX_CONTENT_REDIS_KEY, contentCid + "");
		} catch (Exception e) {
			e.printStackTrace();
			return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return TaotaoResult.ok();
	}

}
