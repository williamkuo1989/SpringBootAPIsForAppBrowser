package com.fih.mobilebrowser.models.uploaddata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attr {

	private String AdId;
	private String ChannelId;
	private String AdSrc;
	private String ClickUrl;
	private String KeyWord;
	private String KeyWordSrc;
	private String RecmdUrl;
	private String RecmdUrlSrc;

	@JsonProperty("AdId")
	public String getAdId() {
		return AdId;
	}
	public void setAdId(String AdId) {
		this.AdId = AdId;
	}
	@JsonProperty("ChannelId")
	public String getChannelId() {
		return ChannelId;
	}
	public void setChannelId(String ChannelId) {
		this.ChannelId = ChannelId;
	}
	@JsonProperty("AdSrc")
	public String getAdSrc() {
		return AdSrc;
	}
	public void setAdSrc(String AdSrc) {
		this.AdSrc = AdSrc;
	}
	@JsonProperty("ClickUrl")
	public String getClickUrl() {
		return ClickUrl;
	}
	public void setClickUrl(String ClickUrl) {
		this.ClickUrl = ClickUrl;
	}
	@JsonProperty("KeyWord")
	public String getKeyWord() {
		return KeyWord;
	}
	public void setKeyWord(String KeyWord) {
		this.KeyWord = KeyWord;
	}
	@JsonProperty("KeyWordSrc")
	public String getKeyWordSrc() {
		return KeyWordSrc;
	}
	public void setKeyWordSrc(String KeyWordSrc) {
		this.KeyWordSrc = KeyWordSrc;
	}
	@JsonProperty("RecmdUrl")
	public String getRecmdUrl() {
		return RecmdUrl;
	}
	public void setRecmdUrl(String RecmdUrl) {
		this.RecmdUrl = RecmdUrl;
	}
	@JsonProperty("RecmdUrlSrc")
	public String getRecmdUrlSrc() {
		return RecmdUrlSrc;
	}
	public void setRecmdUrlSrc(String RecmdUrlSrc) {
		this.RecmdUrlSrc = RecmdUrlSrc;
	}
}
