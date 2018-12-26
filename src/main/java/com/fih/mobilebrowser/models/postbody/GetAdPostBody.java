package com.fih.mobilebrowser.models.postbody;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetAdPostBody {

	private Long AdId;

	@JsonProperty("AdId")
	public Long getAdId() {
		return AdId;
	}
	public void setAdId(Long AdId) {
		this.AdId = AdId;
	}
}
