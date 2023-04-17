package com.myspring.pro28.ex04;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@EnableAsync
public class MailController {
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value="/sendMail.do", method=RequestMethod.GET)
	public void sendSimpleMail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//��ǰ�̹����� ��ũ ������ ������ HTML������ �̸��Ϸ� ������
		StringBuffer sb = new StringBuffer();
		sb.append("<html><body>");
		sb.append("<meta http-equiv='Content-Type' content='text/html; charset=euc-kr'>");
		sb.append("<h1>"+"��ǰ�Ұ�"+"<h1><br>");
		sb.append("�����̸� �Ұ��մϴ�."+"<br><br>");
		sb.append("<a href='https://www.ikea.com/kr/ko/cat/soft-toys-18740/'>");
		sb.append("<img src='https://www.ikea.com/kr/ko/images/products/djungelskog-soft-toy-orangutan__0710167_pe727369_s5.jpg?f=xxs'/><br>");
		sb.append("</a>");
		sb.append("<a href='https://www.ikea.com/kr/ko/p/djungelskog-soft-toy-orangutan-30402840/'>�����̺�������</a>");
		/*
		 * sb.append("<a href='https://www.apple.com/kr/ipad/'>"); sb.
		 * append("<img src='https://search.pstatic.net/common/?src=https%3A%2F%2Fditto-phinf.pstatic.net%2F20221223_38%2F16717880758705SC8t_PNG%2F805f0367734ce3e16e2a57a65d8f3de7.png&type=o&size=488x470&ttype=input'/><br>"
		 * ); sb.append("</a>");
		 * sb.append("<a href='https://www.apple.com/kr/ipad-10.9/'>��ǰ����</a>");
		 */		sb.append("</body></html>");
		String str = sb.toString();
		mailService.sendMail("rlaqha0618@naver.com", "�ȳ��ϼ��� �����̸� �Ұ��մϴ�", str);
		
		out.print("������ ���½��ϴ�.");
	}
	
}
