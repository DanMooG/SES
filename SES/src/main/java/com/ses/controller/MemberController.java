package com.ses.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ses.dto.MemberDTO;
import com.ses.service.MemberService;

@Controller
@Repository
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
			out.println("<script>alert('�������� �ʴ� ȸ���Դϴ�!!'); history.go(-1);</script>");
			out.flush();
		} else if (!dto.getM_PW().equals(request.getParameter("M_PW"))) { // ��й�ȣ�� ��ġ���� ���� ���
			session.setAttribute("mId", null);
			session.setAttribute("mPw", null);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('��й�ȣ�� Ʋ�Ƚ��ϴ�!!'); history.go(-1);</script>");
			out.flush();
		} else { // ����
			session.setAttribute("mId", dto.getM_ID());
			session.setAttribute("mPw", dto.getM_PW());
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('ȯ���մϴ�!!'); document.location.replace('main')</script>");
			out.flush();
		}
		return "main";
	}

	// �α׾ƿ�
	@RequestMapping(value = "/logout")
	public String MLogout(HttpServletResponse response, HttpServletRequest request, RedirectAttributes attr)
			throws Exception {
		System.out.println("Controller - Logout()");

		session.removeAttribute("user");
		session.invalidate();
		mService.logout(response);

		return "main";
	}

	// ȸ������
	@RequestMapping(value = "/doJoin", method = RequestMethod.POST)
	public String MJoin(HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {
		System.out.println("Controller - joinForm()");
		// parameter�� string���� �� �����ϱ� �������� �� �̽� map���� �����ߵȴ� �̽�
		Map<String, Object> map = new HashMap<String, Object>();
		String emails[] = request.getParameter("mEmail").split("@");
		String births[] = request.getParameter("datepicker").split("-");
		
		map.put("mId", request.getParameter("mId"));
		map.put("mPw", request.getParameter("mPw"));
		map.put("mName", request.getParameter("mName"));
		map.put("mEmail1", emails[0]);
		map.put("mEmail2", emails[1]);
		map.put("mTel1", request.getParameter("mTel1"));
		map.put("mTel2", request.getParameter("mTel2"));
		map.put("mTel3", request.getParameter("mTel3"));
		map.put("mBirth1", births[0]);
		map.put("mBirth2", births[1]);
		map.put("mBirth3", births[2]);
		map.put("mFBCHK", request.getParameter("fcYN"));
		map.put("mKTCHK", request.getParameter("ktYN"));
		map.put("mNCHK", request.getParameter("nYN"));
		map.put("mGCHK", request.getParameter("gYN"));
		
		boolean chkId = mService.CheckId(request.getParameter("mId"));
		
		if (chkId) {
			boolean chkJoin = mService.MJoin(map);
			if (chkJoin) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('���ԵǾ����ϴ�'); document.location.replace('login')</script>");
				out.flush();
				return "/login";
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('������ �߻��߽��ϴ�'); document.location.replace('join')</script>");
				out.flush();
				return "/join";
			}
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('���̵� �ߺ��Ǿ����ϴ�'); document.location.replace('join')</script>");
			out.flush();
			return "/join";
		}
	}
}
