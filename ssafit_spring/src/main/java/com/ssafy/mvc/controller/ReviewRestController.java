package com.ssafy.mvc.controller;

import java.io.IOException;

import com.ssafy.mvc.model.dto.ReviewDto;
import com.ssafy.mvc.model.service.ReviewService;
import com.ssafy.mvc.model.service.ReviewServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/review")
public class ReviewRestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewService service = ReviewServiceImpl.getInstance();
	private final String prefix = "/WEB-INF/review";

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");

		switch (action) {
		case "writeform":
			doWriteForm(req, res);
			break;
		case "write":
			doWrite(req, res);
			break;
		case "list":
			doList(req, res);
			break;
		case "detail":
			doDetail(req, res);
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

			break;
		}

	}

	private void doUpdate(HttpServletRequest req, HttpServletResponse res) throws IOException {
		ReviewDto review = service.getReview(Integer.parseInt(req.getParameter("reviewId")));
		review.setModifiedAt(req.getParameter("modifiedAt"));
		review.setContent(req.getParameter("content"));

		service.modifyReview(review);

		res.sendRedirect("review?action=list");
	}

	private void doUpdateForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("reviewId"));

		ReviewDto review = service.getReview(id);
		req.setAttribute("review", review);
		req.getRequestDispatcher(prefix + "updateform.jsp").forward(req, res);
	}

	private void doRemove(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int id = Integer.parseInt(req.getParameter("reviewId"));

		service.removeReview(id);
		res.sendRedirect("review?action=list");
	}

	private void doDetail(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("reviewId"));

		req.setAttribute("review", service.getReview(id));
		req.getRequestDispatcher(prefix + "detail.jsp").forward(req, res);
	}

	// 자신의 리뷰를 일괄 관리할 경우 사용
	private void doList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("list", service.getList());
		req.getRequestDispatcher(prefix + "list.jsp").forward(req, res);
	}

	private void doWrite(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String videoId = req.getParameter("videoId");
		String userId = req.getParameter("userId");
		String content = req.getParameter("content");

		ReviewDto review = new ReviewDto(0, videoId, userId, content, 0, "", "", 0, "");

		service.writeReview(review);

		res.sendRedirect("review?action=list");
	}

	private void doWriteForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher(prefix + "writeform.jsp").forward(req, res);
	}

}
