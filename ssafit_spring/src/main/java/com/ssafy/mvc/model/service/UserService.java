package com.ssafy.mvc.model.service;

import java.util.List;

import com.ssafy.mvc.model.dto.UserDto;

public interface UserService {

	public abstract List<UserDto> getList();

	public abstract UserDto getUser(int id);

	public abstract void registerUser(UserDto user);

	public abstract void modifyUser(UserDto user);

	public abstract void removeUser(int id);

}
