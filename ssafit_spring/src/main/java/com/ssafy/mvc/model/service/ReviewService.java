package com.ssafy.mvc.model.service;

import java.util.List;

import com.ssafy.mvc.model.dto.ReviewDto;

public interface ReviewService {

	public abstract List<ReviewDto> getList();

	public abstract ReviewDto getReview(int id);

	public abstract void writeReview(ReviewDto review);

	public abstract void modifyReview(ReviewDto review);

	public abstract void removeReview(int id);

}
