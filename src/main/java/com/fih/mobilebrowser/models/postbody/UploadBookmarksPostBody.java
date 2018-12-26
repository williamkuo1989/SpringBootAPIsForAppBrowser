package com.fih.mobilebrowser.models.postbody;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fih.mobilebrowser.entities.Bookmark;

public class UploadBookmarksPostBody {

	private List<Bookmark> BookmarkArr;

	@JsonProperty("BookmarkArr")
	public List<Bookmark> getBookmarkArr() {
		return BookmarkArr;
	}
	public void setBookmarkArr(List<Bookmark> BookmarkArr) {
		this.BookmarkArr = BookmarkArr;
	}
}