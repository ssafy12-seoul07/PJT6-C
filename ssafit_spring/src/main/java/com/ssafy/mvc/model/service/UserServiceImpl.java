package com.ssafy.mvc.model.service;

import java.util.List;

import com.ssafy.mvc.model.dao.UserDao;
import com.ssafy.mvc.model.dao.UserDaoImpl;
import com.ssafy.mvc.model.dto.UserDto;

public class UserServiceImpl implements UserService {

	private static UserService service = new UserServiceImpl();
	private UserDao dao = UserDaoImpl.getInstance();

	private UserServiceImpl() {
	}

	public static UserService getInstance() {
		return service;
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