package com.fih.mobilebrowser.models.postbody;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fih.mobilebrowser.models.uploaddata.Meta;
import com.fih.mobilebrowser.models.uploaddata.Rec;

public class UploadDataPostBody {

	private Meta Meta;
	private Rec[] Data;

	@JsonProperty("Meta")
	public Meta getMeta() {
		return Meta;
	}
	public void setMeta(Meta Meta) {
		this.Meta = Meta;
	}
	@JsonProperty("Data")
	public Rec[] getData() {
		return Data;
	}
	public void setData(Rec[] Data) {
		this.Data = Data;
	}
}
