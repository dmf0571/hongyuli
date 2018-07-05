package com.hongyuli.portal.service;

import com.hongyuli.pojo.TbUser;

public interface UserService {

	TbUser getUserByToken(String token);
}
