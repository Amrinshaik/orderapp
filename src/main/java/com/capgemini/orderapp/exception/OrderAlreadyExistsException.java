package com.capgemini.orderapp.exception;

public class OrderAlreadyExistsException extends Exception{
	public OrderAlreadyExistsException(String message) {
		super(message);
}
}
