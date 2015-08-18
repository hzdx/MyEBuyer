package com.mycom.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ExceptionController implements HandlerExceptionResolver{

  @Override
  public ModelAndView resolveException(HttpServletRequest request,
          HttpServletResponse response, Object handler, Exception ex) {
          ex.printStackTrace();
          ModelAndView modelAndView = new ModelAndView();
          modelAndView.addObject("errmsg", ex.getMessage());
          modelAndView.setViewName("/error");
          return modelAndView;
  }

}
