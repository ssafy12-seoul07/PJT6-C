package com.ssafy.mvc.model.dao;

import java.util.List;

import com.ssafy.mvc.model.dto.VideoDto;

public interface VideoDao {
	public List<VideoDto> selectAll();

	public VideoDto selectOne(int id);

	public void updateViews(int id);

}
