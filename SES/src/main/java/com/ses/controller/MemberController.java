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
	// 로그인 폼 보여주기
	@RequestMapping("/Login")
	public String MLoginForm(Model model) {
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
			out.println("<script>alert('존재하지 않는 회원입니다!!'); document.location.href='login';</script>");
			out.flush();
		} else if (!dto.getM_PW().equals(request.getParameter("M_PW"))) { // 비밀번호가 일치하지 않을 경우
			session.setAttribute("M_Id", null);
			session.setAttribute("M_PW", null);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('비밀번호가 틀렸습니다!!'); document.location.href='login';</script>");
			out.flush();
		} else { // 성공
			session.setAttribute("M_Id", dto.getM_ID());
			session.setAttribute("M_PW", dto.getM_PW());
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('환영합니다!!'); document.location.href='main'</script>");
			out.flush();
			return "list";
		}

		return "MainScreen";
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
		@RequestMapping("/join")
		public String MJoinForm(Model model) {
			System.out.println("Controller - join()");
			// timestamp
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			String max = (ts.getYear() + 1900) - 18 + "-12-31";
			String min = (ts.getYear() + 1900) - 101 + "-01-01";

			model.addAttribute("max", max);
			model.addAttribute("min", min);

			return "/join";
		}

		

		// 회원정보수정 화면
		@RequestMapping("/modify")
		public String MModifyForm(HttpServletRequest request, Model model) {
			System.out.println("Controller - Modify()");

			MemberDTO dto = mService.GetMInfo(session.getAttribute("mId").toString());
			//dto.setmBirth(dto.getM_BIRTH1().substring(0, 10));
			//dto.setmBirth(dto.getM_BIRTH2().substring(0, 10));
			//dto.setmBirth(dto.getM_BIRTH3().substring(0, 10));
			

			model.addAttribute("dto", dto);

			return "/member/Mmodify";
		}

		// 회원정보수정 화면
		@RequestMapping("/Mmodify")
		public String MModify(HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {
			System.out.println("Controller - Modify()");			
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("mId", request.getParameter("mId"));
			map.put("mName", request.getParameter("mName"));
			map.put("mTel1", request.getParameter("mTel1"));
			map.put("mTel2", request.getParameter("mTel2"));
			map.put("mTel3", request.getParameter("mTel3"));

			boolean chk = mService.MUpdateInfo(map);

			if (chk) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('회원정보가 수정되었습니다'); document.location.href='list'</script>");
				out.flush();
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('오류가 발생했습니다'); history.go(-1);</script>");
				out.flush();
			}

			return "list";
		}

		// 회원탈퇴 화면
		@RequestMapping("/GetOutForm")
		public String MGetOutForm(Model model) {
			System.out.println("Controller - GetOutForm()");

			return "/member/GetOutForm";
		}

		// 회원탈퇴
		@RequestMapping("/getout")
		public String MGetOut(HttpServletResponse response, Model model) throws IOException {
			System.out.println("Controller - GetOut()");
			
			boolean chk = mService.MGetOut(session.getAttribute("mId").toString());
			
			if (chk) {
				//bService.UpdateMember(session.getAttribute("mId").toString());
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('탈퇴되었습니다'); document.location.href='index'</script>");
				out.flush();
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('오류가 발생했습니다'); history.go(-1);</script>");
				out.flush();
			}
			
			return "/index";
		}
	}

	
