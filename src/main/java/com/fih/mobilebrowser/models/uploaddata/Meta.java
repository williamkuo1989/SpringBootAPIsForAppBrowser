package com.fih.mobilebrowser.models.uploaddata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta {

	private String Ver;

	@JsonProperty("Ver")
	public String getVer() {
		return Ver;
	}
	public void setVer(String Ver) {
		this.Ver = Ver;
	}
}
