package com.ses.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ses.service.LService;
import com.ses.service.MService;
import com.ses.service.QService;
import com.ses.service.SLService;
import com.ses.service.SUService;

@Controller
@Repository
public class PageController {

	// 서비스 인터페이스 갖고 와서 여기서 정의
	@Autowired
	LService Ser_L;
	MService Ser_M;
	QService Ser_Q;
	SUService Ser_SU;
	SLService Ser_SL;

	@Inject
	HttpSession session;

	// 메인화면
	@RequestMapping("/main")
	public String GoMain(HttpServletRequest request, Model model) {
		return "/MainScreen";
	}

	// 로그인
	@RequestMapping("/login")
	public String GoLogin(HttpServletRequest request, Model model) {
		return "/Login";
	}

	// 회원가입
	@RequestMapping("/join")
	public String GoJoin(HttpServletRequest request, Model model) {
		return "/Join";
	}

	// 서비스/회사 소개
	@RequestMapping("/serviceInfo")
	public String GoServiceInfo(HttpServletRequest request, Model model) {
		return "/ServiceInfo";
	}

	// 서비스 이용 절차
	@RequestMapping("/serviceStep")
	public String GoServiceStep(HttpServletRequest request, Model model) {
		return "/ServiceStep";
	}
	
	// 간편가입 조회
	@RequestMapping("/easySearch")
	public String GoEasySearch(HttpServletRequest request, Model model) {
		return "/EasySearch";
	}

	// 간편가입 탈퇴 내역
	@RequestMapping("/searchLog")
	public String GoSearchLog(HttpServletRequest request, Model model) {
		return "/SearchLog";
	}
}
