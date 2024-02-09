package com.cropify.customexception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
