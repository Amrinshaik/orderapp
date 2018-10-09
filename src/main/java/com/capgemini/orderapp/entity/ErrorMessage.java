package com.capgemini.orderapp.entity;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
	private String url;
	private String errorMessage;
	private HttpStatus status;
	private LocalDateTime time;
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorMessage(String url, String errorMessage, HttpStatus status, LocalDateTime time) {
		super();
		this.url = url;
		this.errorMessage = errorMessage;
		this.status = status;
		this.time = time;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "ErrorMessage [url=" + url + ", errorMessage=" + errorMessage + ", status=" + status + ", time=" + time
				+ "]";
	}
	
}
