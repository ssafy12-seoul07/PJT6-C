package com.ssafy.mvc.model.dto;

public class ReviewDto {
	private int reviewId;
	private String videoId;
	private String userId;
	private String content;
	private int parent;
	private String createdAt;
	private String modifiedAt;
	private int userUserId;
	private String videoVideoId;

	public ReviewDto() {
	}

	public ReviewDto(int reviewId, String videoId, String userId, String content, int parent, String createdAt,
			String modifiedAt, int userUserId, String videoVideoId) {
		super();
		this.reviewId = reviewId;
		this.videoId = videoId;
		this.userId = userId;
		this.content = content;
		this.parent = parent;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.userUserId = userUserId;
		this.videoVideoId = videoVideoId;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public int getUserUserId() {
		return userUserId;
	}

	public void setUserUserId(int userUserId) {
		this.userUserId = userUserId;
	}

	public String getVideoVideoId() {
		return videoVideoId;
	}

	public void setVideoVideoId(String videoVideoId) {
		this.videoVideoId = videoVideoId;
	}

	@Override
	public String toString() {
		return "ReviewDto [reviewId=" + reviewId + ", videoId=" + videoId + ", userId=" + userId + ", content="
				+ content + ", parent=" + parent + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt
				+ ", userUserId=" + userUserId + ", videoVideoId=" + videoVideoId + "]";
	}

}
