package com.fih.mobilebrowser.models.uploaddata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rec {

	private String Model;
	private String Event;
	private Attr Attr;
	private Long Date;

	@JsonProperty("Model")
	public String getModel() {
		return Model;
	}
	public void setModel(String Model) {
		this.Model = Model;
	}
	@JsonProperty("Event")
	public String getEvent() {
		return Event;
	}
	public void setEvent(String Event) {
		this.Event = Event;
	}
	@JsonProperty("Attr")
	public Attr getAttr() {
		return Attr;
	}
	public void setAttr(Attr Attr) {
		this.Attr = Attr;
	}
	@JsonProperty("Date")
	public Long getDate() {
		return Date;
	}
	public void setDate(Long Date) {
		this.Date = Date;
	}
}
