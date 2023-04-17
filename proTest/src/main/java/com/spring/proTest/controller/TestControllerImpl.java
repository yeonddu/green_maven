package com.spring.proTest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.proTest.service.TestService;
import com.spring.proTest.vo.TestVO;

@Controller("TestController")
public class TestControllerImpl implements TestController {
	
	@Autowired
	private TestService testService;
	
	@Autowired
	private TestVO testVO;
	
	@RequestMapping(value="/main.do", method = RequestMethod.GET)
	public ModelAndView listTests() throws Exception {
		String viewName = "testform";
		ModelAndView mav = new ModelAndView(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/test9.do", method = RequestMethod.POST)
	public ModelAndView listTests(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String viewName = "listtest";
		System.out.println("viewName: " + viewName);
		List membersList = testService.listTests();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		return mav;
	}
	
}
