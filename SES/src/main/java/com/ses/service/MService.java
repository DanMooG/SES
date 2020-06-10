package com.ses.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ses.dto.MemberDTO;

public interface MService {
	// 아이디 중복 체크
	public boolean CheckId(String M_ID);

	// 회원가입
	public boolean MJoin(Map<String, Object> map);

	// 회원정보수정 화면 보여주기
	public MemberDTO GetMInfo(String M_ID);

	// 회원정보수정
	public boolean MUpdateInfo(Map<String, Object> map);	
	
	// 로그인
	public MemberDTO MLogin(HttpServletRequest request);
	
	// 로그아웃
	public void logout(HttpServletResponse response) throws Exception;

	
}
