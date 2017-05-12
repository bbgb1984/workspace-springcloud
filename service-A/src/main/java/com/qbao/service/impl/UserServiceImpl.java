package com.qbao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qbao.dao.UserMapper;
import com.qbao.entity.User;
import com.qbao.entity.User2;
import com.qbao.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	public UserMapper userMapper;
	
	@Override
	public User findByName(String name) {
		return userMapper.findByName(name);
	}

	@Override
	public int insert(String name, Integer age) {
		return userMapper.insert(name, age);
	}

	@Override
	public List<User2> findAll() {
		// TODO Auto-generated method stub
		return userMapper.findAll();
	}

}
