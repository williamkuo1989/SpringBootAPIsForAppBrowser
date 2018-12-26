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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Ad")
public class Ad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id", unique = true, nullable = false)
	private Long Id;

	@Column(name = "Name", nullable = false)
	private String Name;
	@Column(name = "AdTypeId", nullable = false)
	private Integer AdTypeId;
	@Column(name = "PageId", nullable = false)
	private Integer PageId;
	@Column(name = "Location", nullable = false)
	private Integer Location;
	@Column(name = "StartDate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date StartDate;
	@Column(name = "EndDate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date EndDate;
	@Column(name = "AdStatusId", nullable = false)
	private Integer AdStatusId;

	@JsonIgnore
	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}

	@JsonProperty("Name")
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	@JsonProperty("TypeId")
	public Integer getAdTypeId() {
		return AdTypeId;
	}
	public void setAdTypeId(Integer AdTypeId) {
		this.AdTypeId = AdTypeId;
	}
	@JsonProperty("PageId")
	public Integer getPageId() {
		return PageId;
	}
	public void setPageId(Integer PageId) {
		this.PageId = PageId;
	}
	@JsonProperty("Location")
	public Integer getLocation() {
		return Location;
	}
	public void setLocation(Integer Location) {
		this.Location = Location;
	}
	@JsonProperty("StartDate")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date StartDate) {
		this.StartDate = StartDate;
	}
	@JsonProperty("EndDate")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date EndDate) {
		this.EndDate = EndDate;
	}
	@JsonProperty("StatusId")
	public Integer getAdStatusId() {
		return AdStatusId;
	}
	public void setAdStatusId(Integer AdStatusId) {
		this.AdStatusId = AdStatusId;
	}
}
