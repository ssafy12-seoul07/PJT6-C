package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.UserDao;
import com.ssafy.mvc.model.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	private final UserDao dao;

	public UserServiceImpl(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public List<UserDto> getList() {
		return dao.selectAll();
	}

	@Override
	public UserDto getUser(int id) {
		return dao.selectOne(id);
	}

	@Override
	public void registerUser(UserDto user) {
		dao.registerUser(user);
	}

	@Override
	public void modifyUser(UserDto user) {
		dao.updateUser(user);
	}

	@Override
	public void removeUser(int id) {
		dao.deleteUser(id);
	}

}