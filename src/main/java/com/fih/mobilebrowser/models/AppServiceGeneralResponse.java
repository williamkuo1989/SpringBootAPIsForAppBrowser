package com.fih.mobilebrowser.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "Status", "ErrorMessage", "Data" })
public class AppServiceGeneralResponse<T> {
	private String Status = "Success";
	private String ErrorMessage;
	private T Data;
	@JsonProperty("Status")
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@JsonProperty("ErrorMessage")
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	@JsonProperty("Data")
	public T getData() {
		return Data;
	}
	public void setData(T data) {
		Data = data;
	}
	
}
