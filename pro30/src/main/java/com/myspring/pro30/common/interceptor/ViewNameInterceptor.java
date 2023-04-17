package com.myspring.pro30.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ViewNameInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		//매핑네임을 가져와서 getViewName으로 .do만 자른 후 viewName에 저장
		try {
			String viewName = getViewName(request); //getViewName() 메서드를 이용해 브라우저의 요청명에서 뷰이름 가져오기
			request.setAttribute("viewName", viewName); //뷰이름을 request에 바인딩
		} catch(Exception e) {
			e.printStackTrace();
		}
		return true;		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{
		
	}
	
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if(uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		
		int begin = 0;
		if(!((contextPath == null) || (contextPath.equals("")))) {
			begin = contextPath.length();
		}
		
		int end;
		if(uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1 ) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}
		
		String viewName = uri.substring(begin, end);
		if(viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		
		if(viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		
		return viewName;
	}
}
