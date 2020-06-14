package com.ses.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.CommandMap;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ses.dto.MemberDTO;
import com.ses.service.MemberService;

public class MemberController {
	@Autowired
	MemberService mService;

	@Inject
	HttpSession session;
	//
	// 로그인  보여주기
	@RequestMapping("/Login")
	public String Login(Model model) {
		System.out.println("Controller - Login()");

		return "/Login";
	}

	// 로그인
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String MLogin(HttpServletResponse response, HttpServletRequest request, RedirectAttributes attr)
			throws Exception {
		System.out.println("Controller - doLogin()");
		MemberDTO dto = mService.MLogin(request);

		if (dto == null) { // 해당 회원이 존재하지 않을 경우
			session.setAttribute("M_Id", null);
			session.setAttribute("M_PW", null);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('존재하지 않는 회원입니다!!'); document.location.href='Login';</script>");
			out.flush();
			
		} else if (!dto.getM_PW().equals(request.getParameter("M_PW"))) { // 비밀번호가 일치하지 않을 경우
			session.setAttribute("M_Id", null);
			session.setAttribute("M_PW", null);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('비밀번호가 틀렸습니다!!'); document.location.href='Login';</script>");
			out.flush();
		} else { // 성공
			session.setAttribute("M_Id", dto.getM_ID());
			session.setAttribute("M_PW", dto.getM_PW());
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('환영합니다!!'); document.location.href='Mainscreen'</script>");
			out.flush();
			return "MainScreen";
		}

		return "Login";
	}
	
	// 로그아웃
		@RequestMapping(value = "/Logout")
		public String MLogout(HttpServletResponse response, HttpServletRequest request, RedirectAttributes attr)
				throws Exception {
			System.out.println("Controller - Logout()");

			session.removeAttribute("user");
			session.invalidate();
			mService.logout(response);

			return "index";
		}

		// 회원가입 
		@RequestMapping("/Join")
		public String MJoinForm(Model model) {
			System.out.println("Controller - Join()");			

			return "/Join";
		}

		

		// 회원정보수정 화면
		@RequestMapping("/Modify")
		public String MModifyForm(HttpServletRequest request, Model model) {
			System.out.println("Controller - Modify()");

			MemberDTO dto = mService.GetMInfo(session.getAttribute("M_ID").toString());			

			model.addAttribute("dto", dto);

			return "Modify";
		}

		// 회원정보수정 화면
		@RequestMapping("/Mmodify")
		public String MModify(HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {
			System.out.println("Controller - MModify()");			
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("M_Id", request.getParameter("M_ID"));
			map.put("M_NAME", request.getParameter("M_NAME"));
			map.put("M_EMAIL1", request.getParameter("M_EMAIL1"));
			map.put("M_EMAIL2", request.getParameter("M_EMAIL2"));
			map.put("M_TEL1", request.getParameter("M_TEL1"));
			map.put("M_TEL2", request.getParameter("M_TEL2"));
			map.put("M_TEL3", request.getParameter("M_TEL3"));
			map.put("M_BIRTH1", request.getParameter("M_BIRTH1"));
			map.put("M_BIRTH2", request.getParameter("M_BIRTH2"));
			map.put("M_BIRTH3", request.getParameter("M_BIRTH3"));

			boolean chk = mService.MUpdateInfo(map);

			if (chk) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('회원정보가 수정되었습니다'); document.location.href='MainScreen'</script>");
				out.flush();
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('오류가 발생했습니다'); history.go(-1);</script>");
				out.flush();
			}

			return "MainScreen";
		}
	}

	
