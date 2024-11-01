
package com.ssafy.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.mvc.model.dto.UserDto;

import model.util.DBUtil;

public class UserDaoImpl implements UserDao {
	private DBUtil util = DBUtil.getInstance();
	private static UserDao dao = new UserDaoImpl();

	private UserDaoImpl() {
	}

	public static UserDao getInstance() {
		return dao;
	}

	@Override
	public List<UserDto> selectAll() {
		List<UserDto> list = new ArrayList<>();
		String sql = "SELECT * FROM user";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				UserDto user = new UserDto();
				user.setUserId(0);
				user.setId(sql);
				user.setPassword(sql);
				user.setName(sql);
				user.setEmail(sql);
				user.setStatus(0);
				user.setCreatedAt(sql);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}

		return list;
	}

	@Override
	public UserDto selectOne(int id) {
		String sql = "SELECT * FROM user WHERE id=?";
		UserDto user = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			user = new UserDto();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}
		return user;
	}

	@Override
	public void registerUser(UserDto user) {
		String sql = "INSERT INTO user(id, password, name, email, status) VALUES (?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			pstmt.setInt(5, user.getStatus());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
	}

	public void updateUser(UserDto user) {
		String sql = "UPDATE user SET password=?, name=?, email=?, status=? WHERE id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			pstmt.setInt(5, user.getStatus());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
	}

	@Override
	public void deleteUser(int id) {
		String sql = "DELETE FROM user WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
	}
}