package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.ReviewDao;
import com.ssafy.mvc.model.dto.ReviewDto;

@Service
public class ReviewServiceImpl implements ReviewService {
	private final ReviewDao dao;

	private ReviewServiceImpl(ReviewDao dao) {
		this.dao = dao;
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
