package com.ses.service;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.ses.dao.MemberDAO;
import com.ses.dto.MemberDTO;

@Service
public class MemberService implements MService {
	@Inject
	MemberDAO mDAO;

	// 아이디 중복 체크
	@Override
	public boolean CheckId(String M_ID) {
		return mDAO.CheckId(M_ID);
	}

	// 회원가입
	public boolean MJoin(Map<String, Object> map) {
		return mDAO.MJoin(map);
	}

	// 회원정보수정 화면 보여주기
	@Override
	public MemberDTO GetMInfo(String M_ID) {
		return mDAO.GetMInfo(M_ID);
	}

	// 회원정보수정
	@Override
	public boolean MUpdateInfo(Map<String, Object> map) {
		return mDAO.MUpdateInfo(map);
	}
	

	// 로그인
	@Override
	public MemberDTO MLogin(HttpServletRequest request) {
		MemberDTO dto = mDAO.MLogin(request.getParameter("M_ID"));

		return dto;
	}

	// 로그아웃
	@Override
	public void logout(HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("document.location.href='MainScreen';");
		out.println("</script>");
		out.close();
	}
}
