package com.javaweb.controllerAdvice;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;

import com.javaweb.model.ErrorResponDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Object> handleArithmeticException(
			ArithmeticException ex, WebRequest request) {

		ErrorResponDTO errorResponDTO = new ErrorResponDTO();

		errorResponDTO.setErr(ex.getMessage());
		List<String> detail = new ArrayList<String>();
		detail.add("So nguyen lam sao chi duoc cho 0");
        errorResponDTO.setDetail(detail);
		return new ResponseEntity<>(errorResponDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<Object> handleValidationException(
			ValidationException ex, WebRequest request) {

		ErrorResponDTO errorResponDTO = new ErrorResponDTO();

		errorResponDTO.setErr("Name of NumberOfBasement is null");
		List<String> detail = new ArrayList<String>();
		detail.add("Check lai name or numberOfBasement is null");
        errorResponDTO.setDetail(detail);
		return new ResponseEntity<>(errorResponDTO, HttpStatus.BAD_GATEWAY);
	}
}
