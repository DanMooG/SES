package com.ses.controller;

import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ses.dto.MemberDTO;
import com.ses.service.MemberService;

public class MemberController {
	@Autowired
	MemberService mService;

	@Inject
	HttpSession session;
	
	// �α���
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String MLogin(HttpServletResponse response, HttpServletRequest request, RedirectAttributes attr)
			throws Exception {
		System.out.println("Controller - Login()");
		MemberDTO dto = mService.MLogin(request);
		
		if (dto == null) { // �ش� ȸ���� �������� ���� ���
			session.setAttribute("mId", null);
			session.setAttribute("mPw", null);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('�������� �ʴ� ȸ���Դϴ�!!'); document.location.href='login';</script>");
			out.flush();
		} else if (!dto.getM_PW().equals(request.getParameter("M_PW"))) { // ��й�ȣ�� ��ġ���� ���� ���
			session.setAttribute("mId", null);
			session.setAttribute("mPw", null);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('��й�ȣ�� Ʋ�Ƚ��ϴ�!!'); document.location.href='login';</script>");
			out.flush();
		} else { // ����
			session.setAttribute("mId", dto.getM_ID());
			session.setAttribute("mPw", dto.getM_PW());
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('ȯ���մϴ�!!'); document.location.href='main'</script>");
			out.flush();
			return "list";
		}

		return "main";
	}
}
