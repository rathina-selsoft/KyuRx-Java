package com.selsoft.kyurx.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.selsoft.kyurx.models.User;

@Mapper
public interface UserMapper {

	User findUserByEmail(String email) throws Throwable;

	void insertUserWithRole(User user) throws Throwable;

}
