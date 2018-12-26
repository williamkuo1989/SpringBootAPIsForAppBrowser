package com.fih.mobilebrowser.models.postbody;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetNavPostBody {

	private Long NavId;
	@JsonProperty("NavId")

	public Long getNavId() {
		return NavId;
	}

	public void setNavId(Long NavId) {
		this.NavId = NavId;
	}
}
