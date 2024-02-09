package com.cropify.customexception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cropify.dto.ErrorResponse;

@ControllerAdvice  // mandatory class annotation to tell spring container this class contain
				   // global exception handler methods, offer common advice to controller layer for exception handler
// after adding this class : controller class will contain request handling logic
// this class will contain exception handling logic
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// send details error message regarding validation
//		ex.getBindingResult().getFieldErrors().forEach(fielderr -> sb.append(fielderr.getDefaultMessage()));
		List<String> sb = new ArrayList<String>();
		ex.getBindingResult().getFieldErrors().forEach(fielderr -> sb.add(fielderr.getDefaultMessage()));
		System.out.println(sb); // error messages
		ErrorResponse errorResponse = new ErrorResponse(sb, LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
	
	// for all exception handling method you need @ExceptionHandler
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleRuntimeException(RuntimeException e){  // this is name convention for method name
		System.out.println("In handleRuntimeException method");
		// send error response wrapper in ResponseEntity
		List<String> str = new ArrayList<String>();
		str.add("Error message");
		ErrorResponse errorResponse = new ErrorResponse(str, LocalDateTime.now());  // class in DTO
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	}
	
}
