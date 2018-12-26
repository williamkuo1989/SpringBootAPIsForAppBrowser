package com.fih.mobilebrowser.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InfoFlow {

	private String Name;
	private String ChannelUrl;
	private String NewsUrl;
	private String ApiKey;
	private String ApiSecret;
	private String Bid;

	@JsonProperty("Name")
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	@JsonProperty("ChannelUrl")
	public String getChannelUrl() {
		return ChannelUrl;
	}
	public void setChannelUrl(String ChannelUrl) {
		this.ChannelUrl = ChannelUrl;
	}
	@JsonProperty("NewsUrl")
	public String getNewsUrl() {
		return NewsUrl;
	}
	public void setNewsUrl(String NewsUrl) {
		this.NewsUrl = NewsUrl;
	}
	@JsonProperty("ApiKey")
	public String getApiKey() {
		return ApiKey;
	}
	public void setApiKey(String ApiKey) {
		this.ApiKey = ApiKey;
	}
	@JsonProperty("ApiSecret")
	public String getApiSecret() {
		return ApiSecret;
	}
	public void setApiSecret(String ApiSecret) {
		this.ApiSecret = ApiSecret;
	}
	@JsonProperty("Bid")
	public String getBid() {
		return Bid;
	}
	public void setBid(String Bid) {
		this.Bid = Bid;
	}
}
