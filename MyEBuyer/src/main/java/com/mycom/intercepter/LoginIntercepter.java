package com.mycom.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginIntercepter extends HandlerInterceptorAdapter {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    /*
     * String username = (String) request.getSession().getAttribute("user"); String path =
     * request.getContextPath()+"/user/login"; if(StringUtils.isEmpty(username) &&
     * (!request.getRequestURI().equals(path)) ){
     * response.sendRedirect(request.getContextPath()+"/login.html"); return false; }
     */
    return super.preHandle(request, response, handler);
  }

}
