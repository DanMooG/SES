package com.ses.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
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

import com.ses.dto.LogDTO;
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
		// if (session.getAttribute("mId") == null)
		// return "redirect:main";

		return "/ServiceInfo";
	}

	// ���� �̿� ����
	@RequestMapping("/serviceStep")
	public String GoServiceStep(HttpServletRequest request, Model model) {
		// if (session.getAttribute("mId") == null)
		// return "redirect:main";

		return "/ServiceStep";
	}

	// �����ϱ�
	@RequestMapping("/qna")
	public String GoQna(HttpServletRequest request, Model model) {
		// if (session.getAttribute("mId") == null)
		// return "redirect:main";

		return "/Qna";
	}

	// ������ ��ȸ
	@RequestMapping("/easySearch")
	public String GoEasySearch(HttpServletRequest request, Model model) {
		// if (session.getAttribute("mId") == null)
		// return "redirect:main";
		String kind = request.getParameter("kind");
		String pgNum = request.getParameter("pgnum");
		if (pgNum == null) // null�̸� �� ó��
			pgNum = "1";
		// int������
		int pgnum = Integer.parseInt(pgNum);
		String M_ID = "tytyjacob";
		Map<String, Object> map = new HashMap<String, Object>();
		PageDTO pgDTO = new PageDTO();

		map.put("kind", kind);
		map.put("M_ID", M_ID);

		// ��ü �Խñ� ���� ����
		pgDTO.setTotalCnt(Ser_SL.PageCnt(map));
		// ���� ������ ��ȣ ����
		pgDTO.setPageNum(pgnum);
		// ������ �Խù� �� ����
		pgDTO.setContentNum(5);
		// ���� ������ ��� ����
		pgDTO.setCurBlock(pgnum);
		// ������ ��� ��ȣ ����
		pgDTO.setLastBlock(pgDTO.getTotalCnt());
		// ���� ȭ��ǥ ǥ�� ����
		pgDTO.prevnext(pgnum);
		// ���� ������ ����
		pgDTO.setStartPage(pgDTO.getCurBlock());
		// ������ ������ ����
		pgDTO.setEndPage(pgDTO.getLastBlock(), pgDTO.getCurBlock());

		map = new HashMap<String, Object>();
		map.put("kind", kind);
		map.put("M_ID", M_ID);
		map.put("startNum", (pgnum - 1) * pgDTO.getContentNum());
		map.put("ContentNum", pgDTO.getContentNum());

		List<SiteListDTO> dtos = Ser_SL.GetSLList(map);

		int first = (pgnum - 1) * pgDTO.getContentNum() + 1;
		int last = first + pgDTO.getContentNum();
		int j = 0;
		// �� �Խù� ��ȣ
		for (int i = first; i < last; i++) {
			if (i <= pgDTO.getTotalCnt()) {
				dtos.get(j).setNUM(i);
				j++;
			}
		}

		String prev = "", next = ""; // <, >

		if (pgDTO.isPrev()) { // ���� ����� �����ϴ°�
			prev = "<";
		}
		if (pgDTO.isNext()) { // ���� ����� �����ϴ°�
			next = ">";
		}

		// �Ѿ�� ��µ� ������ ��ȣ��
		int[] pg = new int[(pgDTO.getEndPage() - pgDTO.getStartPage()) + 1];

		// ������ �ڹٽ�ũ��Ʈ �Ἥ ����ߵǴµ� ���� ���� �� �����ͼ� ��ġ�ؾ� �ȴٱ淡
		// �׳� ���⼭ �� ����ؼ� �Ѱ��ֱ�
		j = 0;
		for (int i = pgDTO.getStartPage(); i < pgDTO.getStartPage() + pgDTO.getContentNum(); i++) {
			if (pg.length > j)
				pg[j] = i;
			j++;
		}

		// �� �Ѱ��ֱ�
		model.addAttribute("dtos", dtos);
		model.addAttribute("before", pgDTO.getStartPage() - 1);
		model.addAttribute("after", pgDTO.getEndPage() + 1);
		model.addAttribute("prev", prev);
		model.addAttribute("pg", pg);
		model.addAttribute("next", next);
		if (pgDTO.getTotalCnt() % pgDTO.getContentNum() > 0)
			model.addAttribute("last", pgDTO.getTotalCnt() / pgDTO.getContentNum() + 1);
		else
			model.addAttribute("last", pgDTO.getTotalCnt() / pgDTO.getContentNum());
		model.addAttribute("kind", kind);

		return "/EasySearch";
	}

	// ������ Ż�� ����
	@RequestMapping("/searchLog")
	public String GoSearchLog(HttpServletRequest request, Model model) {
		// if (session.getAttribute("mId") == null)
		// return "redirect:main";

		String M_ID = "tytyjacob";
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("M_ID", M_ID);

		List<LogDTO> dtos = Ser_L.GetLList(map);

		String str = "";
		// �� �Խù� ��ȣ
		for (int i = 0; i < dtos.size(); i++) {
			dtos.get(i).setNUM(i + 1);
			str = dtos.get(i).getL_YEAR() + "-" + dtos.get(i).getL_MONTH() + "-" + dtos.get(i).getL_DAY() + " "
					+ dtos.get(i).getL_HOUR() + ":" + dtos.get(i).getL_MINUTE();
			dtos.get(i).setDATE_HOUR(str);
		}

		// �� �Ѱ��ֱ�
		model.addAttribute("dtos", dtos);

		return "/SearchLog";
	}
}
