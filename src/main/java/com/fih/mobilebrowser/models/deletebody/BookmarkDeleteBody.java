package com.fih.mobilebrowser.models.deletebody;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookmarkDeleteBody {

	private Long[] ToDeleteBookmarkIdArr;

	@JsonProperty("ToDeleteBookmarkIdArr")
	public Long[] gettoDeleteBookmarkIdArr() {
		return ToDeleteBookmarkIdArr;
	}
	public void settoDeleteBookmarkIdArr(Long[] ToDeleteBookmarkIdArr) {
		this.ToDeleteBookmarkIdArr = ToDeleteBookmarkIdArr;
	}
}
