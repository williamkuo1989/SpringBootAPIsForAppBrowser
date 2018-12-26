package com.fih.mobilebrowser.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"Name","SearchUrl","HotWordUrl","SearchWordUrl","Bid","Pid","Cid"})
public class SearchConfig {

	private String Name;
	private String SearchUrl;
	private String HotWordUrl;
	private String SearchWordUrl;
	private String Bid;
	private String Pid;
	private String Cid;

	@JsonProperty("Name")
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	@JsonProperty("SearchUrl")
	public String getSearchUrl() {
		return SearchUrl;
	}
	public void setSearchUrl(String SearchUrl) {
		this.SearchUrl = SearchUrl;
	}
	@JsonProperty("HotWordUrl")
	public String getHotWordUrl() {
		return HotWordUrl;
	}
	public void setHotWordUrl(String HotWordUrl) {
		this.HotWordUrl = HotWordUrl;
	}
	@JsonProperty("SearchWordUrl")
	public String getSearchWordUrl() {
		return SearchWordUrl;
	}
	public void setSearchWordUrl(String SearchWordUrl) {
		this.SearchWordUrl = SearchWordUrl;
	}
	@JsonProperty("Bid")
	public String getBid() {
		return Bid;
	}
	public void setBid(String Bid) {
		this.Bid = Bid;
	}
	@JsonProperty("Pid")
	public String getPid() {
		return Pid;
	}
	public void setPid(String Pid) {
		this.Pid = Pid;
	}
	@JsonProperty("Cid")
	public String getCid() {
		return Cid;
	}
	public void setCid(String Cid) {
		this.Cid = Cid;
	}
}
