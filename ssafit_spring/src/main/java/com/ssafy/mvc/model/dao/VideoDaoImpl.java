package com.ssafy.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.mvc.model.dto.VideoDto;

import model.util.DBUtil;

public class VideoDaoImpl implements VideoDao {
	private DBUtil util = DBUtil.getInstance();
	private static VideoDao dao = new VideoDaoImpl();

	private VideoDaoImpl() {

	}

	public static VideoDao getInstance() {
		return dao;
	}

	@Override
	public List<VideoDto> selectAll() {
		List<VideoDto> list = new ArrayList<>();
		String sql = "SELECT * FROM board";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				VideoDto video = new VideoDto();
				video.setVideoId(rs.getString("video_id"));
				video.setTitle(rs.getString("title"));
				video.setPart(rs.getString("part"));
				video.setChannelName(rs.getString("channel_name"));
				video.setUrl(rs.getString("url"));
				video.setThumbnail(rs.getString("thumbnail"));
				video.setViews(rs.getInt("views"));

				list.add(video);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}
		return list;

	}

	@Override
	public VideoDto selectOne(int id) {
		VideoDto video = null;

		String sql = "SELECT * FROM video WHERE id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			video = new VideoDto();

			while (rs.next()) {
				video.setVideoId(rs.getString("video_id"));
				video.setTitle(rs.getString("title"));
				video.setPart(rs.getString("part"));
				video.setChannelName(rs.getString("channel_name"));
				video.setUrl(rs.getString("url"));
				video.setThumbnail(rs.getString("thumbnail"));
				video.setViews(rs.getInt("views"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}

		return video;
	}

	@Override
	public void updateViews(int id) {
		String sql = "UPDATE video SET views= views+1 WHERE id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
	}
}
