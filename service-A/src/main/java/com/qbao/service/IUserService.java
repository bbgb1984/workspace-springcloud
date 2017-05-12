package com.qbao.service;

import java.util.List;

import com.qbao.entity.User;
import com.qbao.entity.User2;

public interface IUserService {

	User findByName(String name);
	
	int insert(String name,Integer age);
	
	List<User2> findAll();
}
