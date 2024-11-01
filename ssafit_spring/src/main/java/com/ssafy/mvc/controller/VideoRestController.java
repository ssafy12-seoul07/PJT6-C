package com.ssafy.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.VideoDto;
import com.ssafy.mvc.model.service.VideoService;

@RestController
@RequestMapping("/api/video")
public class VideoRestController{
	private final VideoService service;

	@Autowired
	public VideoRestController(VideoService videoService) {
		this.service = videoService;
	}

	// 비디오 상세정보
	@GetMapping("/{videoId}")
	private ResponseEntity<?> doPlayer(@PathVariable int videoId) {
		VideoDto video = service.getVideo(videoId);
		return new ResponseEntity<>(video, HttpStatus.OK);
	}
}
