package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.VideoDao;
import com.ssafy.mvc.model.dto.VideoDto;

@Service
public class VideoServiceImpl implements VideoService {
	private final VideoDao dao;

	private VideoServiceImpl(VideoDao dao) {
		this.dao = dao;
	}

	@Override
	public List<VideoDto> getList() {
		return dao.selectAll();
	}

	@Override
	public VideoDto getVideo(int id) {
		dao.updateViews(id);
		return dao.selectOne(id);
	}

//	@Override
//	public void writeVideo(VideoDto video) {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	public void modifyVideo(VideoDto video) {
//		// TODO Auto-generated method stub
//	}
//
//	@Override
//	public void removeVideo(int id) {
//		// TODO Auto-generated method stub
//	}

}
