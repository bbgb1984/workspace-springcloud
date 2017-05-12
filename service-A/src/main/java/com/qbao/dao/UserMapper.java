package com.qbao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import com.qbao.entity.User;
import com.qbao.entity.User2;

@Mapper
@CacheConfig(cacheNames = "users")
public interface UserMapper {
	
	@Cacheable
	@Select("SELECT * FROM USER WHERE NAME = #{name}")
	User findByName(@Param("name") String name);

	@Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
	int insert(@Param("name") String name, @Param("age") Integer age);
	
	
//	@Results用于查询列名和实体类不匹配时的转换
	@Results({
	    @Result(property = "name2", column = "name"),
	    @Result(property = "age", column = "age")
	})
	@Select("SELECT name, age FROM user")
	List<User2> findAll();
}