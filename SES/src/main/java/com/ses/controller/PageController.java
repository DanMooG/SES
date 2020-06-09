package com.ses.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ses.dto.MemberDTO;
import com.ses.dto.PageDTO;
import com.ses.dto.SiteListDTO;
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
	@Autowired
	MService Ser_M;
	@Autowired
	QService Ser_Q;
	@Autowired
	SUService Ser_SU;
	@Autowired
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

	// �����ϱ�
	@RequestMapping("/qna")
	public String GoQna(HttpServletRequest request, Model model) {
		return "/Qna";
	}

	// ������ ��ȸ
	@RequestMapping("/easySearch")
	public String GoEasySearch(HttpServletRequest request, Model model) {
		String kind = request.getParameter("kind");
		String M_ID = "tytyjacob";
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("kind", kind);
		map.put("M_ID", M_ID);

		List<SiteListDTO> dtos_origin = Ser_SL.GetSLList(map);

		// �� �Ѱ��ֱ�
		model.addAttribute("dtos", dtos_origin);
		model.addAttribute("kind", kind);

		return "/EasySearch";
	}

	// ������ Ż�� ����
	@RequestMapping("/searchLog")
	public String GoSearchLog(HttpServletRequest request, Model model) {
		return "/SearchLog";
	}
}
