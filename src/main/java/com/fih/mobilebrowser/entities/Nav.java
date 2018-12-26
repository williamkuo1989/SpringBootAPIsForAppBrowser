package com.fih.mobilebrowser.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Nav")
public class Nav {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id", unique = true, nullable = false)
	private Long Id;

	@Column(name = "Position", nullable = false)
	private Integer Position;
	@Column(name = "Name", nullable = false)
	private String Name;
	@Column(name = "IconUrl", nullable = false)
	private String IconUrl;
	@Column(name = "ClickUrl", nullable = false)
	private String ClickUrl;
	@Column(name = "NavTypeId", nullable = false)
	private Integer NavTypeId;

	@JsonIgnore
	public Long getId() {
		return Id;
	}
	public void setId(Long Id) {
		this.Id = Id;
	}

	@JsonProperty("Position")
	public Integer getPosition() {
		return Position;
	}
	public void setPosition(Integer Position) {
		this.Position = Position;
	}
	@JsonProperty("Name")
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	@JsonProperty("IconUrl")
	public String getIconUrl() {
		return IconUrl;
	}
	public void setIconUrl(String IconUrl) {
		this.IconUrl = IconUrl;
	}
	@JsonProperty("ClickUrl")
	public String getClickUrl() {
		return ClickUrl;
	}
	public void setClickUrl(String ClickUrl) {
		this.ClickUrl = ClickUrl;
	}
	@JsonProperty("TypeId")
	public Integer getNavTypeId() {
		return NavTypeId;
	}
	public void setNavTypeId(Integer NavTypeId) {
		this.NavTypeId = NavTypeId;
	}
}
