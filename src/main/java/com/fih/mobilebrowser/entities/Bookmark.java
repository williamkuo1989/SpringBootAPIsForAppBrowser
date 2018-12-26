package com.fih.mobilebrowser.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Bookmark")
public class Bookmark {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true)
	private Long id;

	@Column(name = "AccId", nullable = false)
	private String accId;
	@Column(name = "Name", nullable = false)
	private String name;
	@Column(name = "WebUrl", nullable = false)
	private String webUrl;
	@Column(name = "IconUrl", nullable = false)
	private String iconUrl;
	@Column(name = "CreatedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Column(name = "ModifiedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Column(name = "Uuid")
	private String uuid;

	@JsonProperty("Id")
	public Long getid() {
		return id;
	}
	public void setid(Long id) {
		this.id = id;
	}
	@JsonIgnore
	public String getaccId() {
		return accId;
	}
	public void setaccId(String accId) {
		this.accId = accId;
	}
	@JsonProperty("Name")
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	@JsonProperty("WebUrl")
	public String getwebUrl() {
		return webUrl;
	}
	public void setwebUrl(String webUrl) {
		this.webUrl = webUrl;
	}
	@JsonProperty("IconUrl")
	public String geticonUrl() {
		return iconUrl;
	}
	public void seticonUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	@JsonIgnore
	public Date getcreatedDate() {
		return createdDate;
	}
	public void setcreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@JsonIgnore
	public Date getmodifiedDate() {
		return modifiedDate;
	}
	public void setmodifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	@JsonProperty("Uuid")
	public String getuuId() {
		return uuid;
	}
	public void setuuId(String uuid) {
		this.uuid = uuid;
	}
}
