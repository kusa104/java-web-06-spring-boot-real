package com.example.advice;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.example.exception.DefaultException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ExampleControllerAdvice {

	/**
	 * Exception 발생에 예외처리
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		log.error("handleException", e);
		return handle(e);
	}
	
	/**
	 * BindException 발생에 예외처리
	 * @param e
	 * @return
	 */
	@ExceptionHandler(BindException.class)
	public ModelAndView handleBindException(BindException e) {
		log.error("handleBindException", e);
		ModelAndView view = new ModelAndView("/error/message.html");
		FieldError fieldError = e.getFieldError();
		view.addObject("message", fieldError.getDefaultMessage());		
		return view;
	}
	
	/**
	 * DefaultException 발생에 예외처리
	 * @param e
	 * @return
	 */
	@ExceptionHandler(DefaultException.class)
	public ModelAndView handleDefaultException(DefaultException e) {
		log.error("handleDefaultException", e);
		return handle(e);
	}
	
	private ModelAndView handle(Exception e) {
		ModelAndView view = new ModelAndView("/error/error.html");
		view.addObject("exception", e);
		return view;
	}
}
