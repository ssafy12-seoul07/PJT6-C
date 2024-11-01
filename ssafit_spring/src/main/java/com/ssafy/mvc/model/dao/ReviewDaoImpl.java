package com.ssafy.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.mvc.model.dto.ReviewDto;

public class ReviewDaoImpl implements ReviewDao {
	private static ReviewDao dao = new ReviewDaoImpl();

	private ReviewDaoImpl() {
	}

	public static ReviewDao getInstance() {
		return dao;
	}

	@Override
	public List<ReviewDto> selectAll() {
		List<ReviewDto> list = new ArrayList<>();
		String sql = "SELECT * FROM review";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReviewDto review = new ReviewDto();
				review.setReviewId(0);
				review.setVideoId(sql);
				review.setUserId(sql);
				review.setContent(sql);
				review.setParent(0);
				review.setCreatedAt(sql);
				review.setModifiedAt(sql);
				review.setUserUserId(0);
				review.setVideoVideoId(sql);

				list.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public ReviewDto selectOne(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM review WHERE id=?";
		ReviewDto review = null;
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			review = new ReviewDto();
			while (rs.next()) {
				review.setReviewId(rs.getInt(1));
				review.setVideoId(rs.getString(2));
				review.setUserId(rs.getString(3));
				review.setContent(rs.getString(4));
				review.setParent(rs.getInt(5));
				review.setCreatedAt(rs.getString(6));
				review.setModifiedAt(rs.getString(7));
				review.setUserUserId(rs.getInt(8));
				review.setVideoVideoId(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}
		return review;
	}

	@Override
	public void insertReview(ReviewDto review) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO review (title, writer, content) VALUES(?,?,?)";

		try {
			conn = util.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, review.getReviewId());
			pstmt.setString(2, review.getVideoId());
			pstmt.setString(3, review.getUserId());
			pstmt.setString(4, review.getContent());
			pstmt.setInt(5, review.getParent());
			pstmt.setString(6, review.getCreatedAt());
			pstmt.setString(7, review.getModifiedAt());
			pstmt.setInt(8, review.getUserUserId());
			pstmt.setString(9, review.getVideoVideoId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}

	}

	@Override
	public void updateReview(ReviewDto review) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "UPDATE review SET content=?, parent=? WHERE id=?";

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(4, review.getContent());
			pstmt.setInt(5, review.getParent());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}

	}

	@Override
	public void deleteReview(int id) {
		String sql = "DELETE FROM review WHERE id = ?";
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
