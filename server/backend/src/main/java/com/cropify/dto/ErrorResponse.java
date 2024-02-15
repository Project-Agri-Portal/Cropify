package com.cropify.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {
	private List<String> errorMessage;
	private LocalDateTime timeStamp;
	public ErrorResponse() {
		super();
	}
	public ErrorResponse(List<String> errorMessage, LocalDateTime timeStamp) {
		super();
		this.errorMessage = errorMessage;
		this.timeStamp = timeStamp;
	}
	/**
	 * @return the errorMessage
	 */
	public List<String> getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(List<String> errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the timeStamp
	 */
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public void setMessage(String str) {
		errorMessage.add(str);
	}
	
}
