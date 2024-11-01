package com.ssafy.mvc.controller;

import java.io.IOException;

import com.ssafy.mvc.model.dto.UserDto;
import com.ssafy.mvc.model.service.UserService;
import com.ssafy.mvc.model.service.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserRestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service = UserServiceImpl.getInstance();
	private final String prefix = "/WEB-INF/user/";

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");

		switch (action) {
		case "registerform":
			doRegisterForm(req, res);
			break;
		case "register":
			doRegister(req, res);
			break;
		case "favorite":
			doFavorite(req, res);
			break;
		case "reviewList":
			doReviewList(req, res);
			break;
		case "profile":
			doProfile(req, res);
			break;
		case "delete":
			doRemove(req, res);
			break;
		case "updateform":
			doUpdateForm(req, res);
			break;
		case "update":
			doUpdate(req, res);
			break;
		default:
// 에러 페이지로 연결
			break;
		}

	}

	private void doUpdate(HttpServletRequest req, HttpServletResponse res) throws IOException {
		UserDto user = service.getUser(Integer.parseInt(req.getParameter("userId")));
		user.setName(req.getParameter("userName"));
		user.setEmail(req.getParameter("userEmail"));
		user.setPassword(req.getParameter("password"));

		service.modifyUser(user);

		res.sendRedirect(prefix + "?action=profile");
	}

	// 유저 정보 수정
	private void doUpdateForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("userId"));

		UserDto user = service.getUser(id);
		req.setAttribute("user", user);
		req.getRequestDispatcher(prefix + "updateform.jsp").forward(req, res);
	}

	// 회원 탈퇴
	private void doRemove(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int id = Integer.parseInt(req.getParameter("userId"));

		service.removeUser(id);
		res.sendRedirect(prefix + "?action=remove");
	}

	// 유저 프로필 열람
	// 본인의 프로필인 경우 수정 가능
	// 타인의 프로필인 경우 팔로우 등
	private void doProfile(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("userId"));

		req.setAttribute("user", service.getUser(id));
		req.getRequestDispatcher(prefix + "profile.jsp").forward(req, res);
	}

	// 자신의 리뷰 목록을 관리
	private void doReviewList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("reviewList", service.getList());
		req.getRequestDispatcher(prefix + "reviews.jsp").forward(req, res);
	}

	// 자신의 찜 목록을 관리
	private void doFavorite(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("favoriteList", service.getList());
		req.getRequestDispatcher(prefix + "favorite.jsp").forward(req, res);
	}

	// 회원가입
	private void doRegister(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String id = req.getParameter("userId");
		String password = req.getParameter("password");
		String name = req.getParameter("userName");
		String email = req.getParameter("userEmail");

		UserDto user = new UserDto(0, id, password, name, email, 0, "");

		service.registerUser(user);

		res.sendRedirect(prefix + "?action=register");
	}

	private void doRegisterForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher(prefix + "registerform.jsp").forward(req, res);
	}

}
