package com.bingo.service;

import java.util.List;

import com.bingo.entity.User;
import com.bingo.entity.User2;

public interface IUserService {

	User findByName(String name);
	
	int insert(String name,Integer age);
	
	List<User2> findAll();
}
