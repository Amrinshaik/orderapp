package com.capgemini.orderapp.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.orderapp.entity.ErrorMessage;
import com.capgemini.orderapp.exception.OrderAlreadyExistsException;
import com.capgemini.orderapp.exception.OrderDoesnotExistsException;


@ControllerAdvice
public class ExceptionController {
	static Logger logger = LoggerFactory.getLogger(ExceptionController.class);

	@ExceptionHandler(value = OrderAlreadyExistsException.class)
	public ResponseEntity<ErrorMessage> orderAlreadyExistsException(HttpServletRequest request,
			OrderAlreadyExistsException exception) {
		ErrorMessage errorMessage = new ErrorMessage(request.getRequestURI(), exception.getMessage(),
				HttpStatus.FOUND, LocalDateTime.now());
		logger.error(exception.toString());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.FOUND);
	}

	@ExceptionHandler(value = OrderDoesnotExistsException.class)
	public ResponseEntity<ErrorMessage> orderNotFoundException(HttpServletRequest request,
			OrderDoesnotExistsException exception) {
		ErrorMessage errorMessage = new ErrorMessage(request.getRequestURI(), exception.getMessage(),
				 HttpStatus.NOT_FOUND, LocalDateTime.now());
		logger.error(exception.toString());
		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
	}
}
