package com.ssafy.mvc.model.service;

import java.util.List;

import com.ssafy.mvc.model.dao.ReviewDao;
import com.ssafy.mvc.model.dao.ReviewDaoImpl;
import com.ssafy.mvc.model.dto.ReviewDto;

public class ReviewServiceImpl implements ReviewService {
	private static ReviewService service = new ReviewServiceImpl();
	private ReviewDao dao = ReviewDaoImpl.getInstance();

	private ReviewServiceImpl() {
	}

	public static ReviewService getInstance() {
		return service;
	}

	@Override
	public List<ReviewDto> getList() {
		return dao.selectAll();
	}

	@Override
	public ReviewDto getReview(int id) {
		return dao.selectOne(id);
	}

	@Override
	public void writeReview(ReviewDto review) {
		dao.insertReview(review);
	}

	@Override
	public void modifyReview(ReviewDto review) {
		dao.updateReview(review);
	}

	@Override
	public void removeReview(int id) {
		dao.deleteReview(id);
	}

}
