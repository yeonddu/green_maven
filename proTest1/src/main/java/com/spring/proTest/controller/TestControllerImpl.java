package com.spring.proTest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.proTest.service.TestService;
import com.spring.proTest.vo.TestVO;


@Controller("TestController")
public class TestControllerImpl {
	private static final Logger logger = LoggerFactory.getLogger(TestControllerImpl.class);
	
	@Autowired
	private TestService testService;
	@Autowired
	private TestVO testVO;

	@Override
	@RequestMapping(value="/test9.do", method = RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		//인터셉터에서 바인딩된 뷰이름 가져오기
		//String viewName = (String)request.getAttribute("viewName"); 
		logger.info(viewName);
		logger.debug(viewName);
		System.out.println("viewName: " + viewName);
		List membersList = testService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		return mav;
	}
	
}
