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
	
	//서비스 인터페이스 갖고 와서 여기서 정의
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
	public String MIndex(HttpServletRequest request, Model model) {
		return "/MainScreen";
	}
}
