package com.fih.mobilebrowser.entities;

import java.sql.Time;
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
@Table(name = "Word")
public class Word {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id", unique = true, nullable = false)
	private Long id;

	@Column(name = "Word", nullable = false)
	private String word;
	@Column(name = "WordTypeId", nullable = false)
	private Integer wordTypeId;
	@Column(name = "Target", nullable = false)
	private String target;
	@Column(name = "WordSrcId", nullable = false)
	private Integer wordSrcId;
	@Column(name = "Weight", nullable = false)
	private Integer weight;
	@Column(name = "WordStatusId", nullable = false)
	private Integer wordStatusId;
	@Column(name = "StartDate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	@Column(name = "EndDate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	@Column(name = "DateTypeId", nullable = false)
	private Integer dateTypeId;
	@Column(name = "StartTime", nullable = true)
	private Time startTime;
	@Column(name = "EndTime", nullable = true)
	private Time endTime;
	@Column(name = "TimeTypeId", nullable = true)
	private Integer timeTypeId;

	@JsonIgnore
	public Long getId() {
		return id;
	}
	public void setId(Long Id) {
		this.id = Id;
	}

	@JsonProperty("Word")
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	@JsonProperty("WordTypeId")
	public Integer getWordTypeId() {
		return wordTypeId;
	}
	public void setWordTypeId(Integer wordTypeId) {
		this.wordTypeId = wordTypeId;
	}
	@JsonProperty("Target")
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	@JsonProperty("WordSrcId")
	public Integer getWordSrcId() {
		return wordSrcId;
	}
	public void setWordSrcId(Integer wordSrcId) {
		this.wordSrcId = wordSrcId;
	}
	@JsonProperty("StartDate")
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@JsonProperty("EndDate")
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@JsonProperty("DateTypeId")
	public Integer getDateTypeId() {
		return dateTypeId;
	}
	public void setDateTypeId(Integer dateTypeId) {
		this.dateTypeId = dateTypeId;
	}
	@JsonProperty("StartTime")
	@JsonFormat(pattern="HH:mm:ss")
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	@JsonProperty("EndTime")
	@JsonFormat(pattern="HH:mm:ss")
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
}
