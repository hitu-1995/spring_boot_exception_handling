package com.cjc.in.globalhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cjc.in.exception.CIDInvalidException;
import com.cjc.in.exception.KeyNotFoundException;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

	Logger log = LoggerFactory.getLogger(MyExceptionHandler.class);

	@ExceptionHandler(KeyNotFoundException.class)
	public ResponseEntity<String> keyInvalidExcp() {
		log.warn("KeyNotFoundException :: Wrong Key Please Check");
		return new ResponseEntity<String>("Wrong Key Please Check", HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(CIDInvalidException.class)
	public ResponseEntity<String> invalidId() {

		return new ResponseEntity<String>("Invalid Id Format Should be three disgits", HttpStatus.BAD_REQUEST);

	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		return new ResponseEntity<Object>("Method Not Supported Exception", HttpStatus.NOT_ACCEPTABLE);
	}

}
