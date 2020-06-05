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

	// ���� �������̽� ���� �ͼ� ���⼭ ����
	@Autowired
	LService Ser_L;
	MService Ser_M;
	QService Ser_Q;
	SUService Ser_SU;
	SLService Ser_SL;

	@Inject
	HttpSession session;

	// ����ȭ��
	@RequestMapping("/main")
	public String GoMain(HttpServletRequest request, Model model) {
		return "/MainScreen";
	}

	// �α���
	@RequestMapping("/login")
	public String GoLogin(HttpServletRequest request, Model model) {
		return "/Login";
	}

	// ȸ������
	@RequestMapping("/join")
	public String GoJoin(HttpServletRequest request, Model model) {
		return "/Join";
	}

	// ����/ȸ�� �Ұ�
	@RequestMapping("/serviceInfo")
	public String GoServiceInfo(HttpServletRequest request, Model model) {
		return "/ServiceInfo";
	}

	// ���� �̿� ����
	@RequestMapping("/serviceStep")
	public String GoServiceStep(HttpServletRequest request, Model model) {
		return "/ServiceStep";
	}
	
	// �������� ��ȸ
	@RequestMapping("/easySearch")
	public String GoEasySearch(HttpServletRequest request, Model model) {
		return "/EasySearch";
	}

	// �������� Ż�� ����
	@RequestMapping("/searchLog")
	public String GoSearchLog(HttpServletRequest request, Model model) {
		return "/SearchLog";
	}
}