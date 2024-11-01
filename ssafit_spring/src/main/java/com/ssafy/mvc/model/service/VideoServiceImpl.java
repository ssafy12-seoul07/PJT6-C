package com.ssafy.mvc.model.service;

import java.util.List;

import com.ssafy.mvc.model.dao.VideoDao;
import com.ssafy.mvc.model.dao.VideoDaoImpl;
import com.ssafy.mvc.model.dto.VideoDto;

public class VideoServiceImpl implements VideoService {
	private static VideoService service = new VideoServiceImpl();
	private VideoDao dao = VideoDaoImpl.getInstance();

	private VideoServiceImpl() {
	}

	public static VideoService getInstance() {
		return service;
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
