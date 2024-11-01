package com.ssafy.mvc.model.dao;

import java.util.List;

import com.ssafy.mvc.model.dto.UserDto;

public interface UserDao {
	public List<UserDto> selectAll();

	public UserDto selectOne(int id);

	public void registerUser(UserDto user);

	public void updateUser(UserDto user);

	public void deleteUser(int id);

}
