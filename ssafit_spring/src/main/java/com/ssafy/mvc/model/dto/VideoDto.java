package com.ssafy.mvc.model.dto;

public class VideoDto {
	private String videoId;
	private String title;
	private String part;
	private String channelName;
	private String url;
	private String thumbnail;
	private int views;
	private int status;

	public VideoDto(String videoId, String title, String part, String channelName, String url, String thumbnail,
			int views, int status) {
		super();
		this.videoId = videoId;
		this.title = title;
		this.part = part;
		this.channelName = channelName;
		this.url = url;
		this.thumbnail = thumbnail;
		this.views = views;
		this.status = status;
	}

	public VideoDto() {
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "VideoDto [videoId=" + videoId + ", title=" + title + ", part=" + part + ", channelName=" + channelName
				+ ", url=" + url + ", thumbnail=" + thumbnail + ", views=" + views + ", status=" + status + "]";
	}

}
