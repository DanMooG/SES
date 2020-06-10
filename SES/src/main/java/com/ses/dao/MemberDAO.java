package com.ses.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ses.dto.MemberDTO;

@Repository
public interface MemberDAO {
	// 아이디 중복 체크
	public boolean CheckId(String M_ID);

	// 회원가입
	public boolean MJoin(Map<String, Object> map);

	// 회원정보수정 화면 보여주기
	public MemberDTO GetMInfo(String M_ID);

	// 회원정보수정
	public boolean MUpdateInfo(Map<String, Object> map);	

	// 로그인
	public MemberDTO MLogin(String M_ID);

}