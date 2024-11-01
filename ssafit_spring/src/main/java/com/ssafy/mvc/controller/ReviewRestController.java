package com.ssafy.mvc.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.ReviewDto;
import com.ssafy.mvc.model.service.ReviewService;

@RestController
@RequestMapping("/api")
public class ReviewRestController {
	private final ReviewService service;

	@Autowired
	public ReviewRestController(ReviewService service) {
		this.service = service;
	}

	// 영상 id를 통해 해당 영상 내 리뷰를 가져옴
	@GetMapping("/video/{videoId}/reviews")
	private ResponseEntity<?> getReviews(@PathVariable int videoId) {
		List<ReviewDto> list = service.getList();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// id로 리뷰를 반환
	@GetMapping("/review/{reviewId}")
	private ResponseEntity<?> getReview(@PathVariable("reviewId") int reviewId) {
		ReviewDto review = service.getReview(reviewId);
		return new ResponseEntity<>(review, HttpStatus.OK);
	}

	@PostMapping("/review")
	private ResponseEntity<?> doWrite(@ModelAttribute ReviewDto review) {
		service.writeReview(review);

		return new ResponseEntity<ReviewDto>(review, HttpStatus.OK);
	}

	@PutMapping("/review/{reviewId}")
	private ResponseEntity<?> doUpdate(@RequestBody ReviewDto review, @PathVariable int reviewId) throws IOException {
		service.modifyReview(review);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/review/{reviewId}")
	private ResponseEntity<?> doRemove(@PathVariable int reviewId) {
		service.removeReview(reviewId);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
