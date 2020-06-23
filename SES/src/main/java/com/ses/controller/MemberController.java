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
import com.ses.service.MService;
import com.ses.service.MemberService;

@Controller
@Repository
public class MemberController {
	@Autowired
	MService mService;

	@Inject
	HttpSession session;
	
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
			return "MainScreen";
		}

		return "login";
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
		@RequestMapping("/doJoin")
		public String MJoin(HttpServletResponse response, HttpServletRequest request, Model model) throws IOException {
			System.out.println("Controller - doJoin()");
			
			String birth[] = request.getParameter("mBirth").split("-");			
			
			for(int i=0 ; i<birth.length ; i++)
	        {
	            System.out.println("birth["+i+"] : "+birth[i]);
	        }
			
			String email[] = request.getParameter("email").split("@");
			
			for(int i=0 ; i<email.length ; i++)
	        {
	            System.out.println("email["+i+"] : "+email[i]);
	        }
			
			
			Map<String, Object> map = new HashMap<String, Object>();

			map.put("M_ID", request.getParameter("M_ID"));
			map.put("M_NAME", request.getParameter("M_NAME"));
			map.put("M_PW", request.getParameter("M_PW"));
			map.put("M_PWCHK", request.getParameter("M_PWCHK"));
			map.put("M_TEL1", request.getParameter("phoneNumber1"));
			map.put("M_TEL2", request.getParameter("phoneNumber2"));
			map.put("M_TEL3", request.getParameter("phoneNumber3"));
			map.put("M_BIRTH1", birth[0]);
			map.put("M_BIRTH2", birth[1]);
			map.put("M_BIRTH3", birth[2]);			
			map.put("M_EMAIL1", email[0]);
			map.put("M_EAMIL2", email[1]);

			boolean chkId = mService.CheckId(request.getParameter("M_ID"));

			if (chkId) {
				boolean chkJoin = mService.MJoin(map);
				if (chkJoin) {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('가입되었습니다'); document.location.href='login'</script>");
					out.flush();
				} else {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>alert('오류가 발생했습니다'); history.go(-1);</script>");
					out.flush();
				}
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('아이디가 중복되었습니다'); history.go(-1);</script>");
				out.flush();
			}
			return "login";
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

	
