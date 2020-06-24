package com.ses.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ses.dto.MemberDTO;

public interface MService {

	// 로그인
	public MemberDTO MLogin(HttpServletRequest request);

	// 로그아웃
	public void logout(HttpServletResponse response) throws Exception;

	// 아이디 중복 체크
	public boolean CheckId(String mId);

	// 회원가입
	public boolean MJoin(Map<String, Object> map);
}
