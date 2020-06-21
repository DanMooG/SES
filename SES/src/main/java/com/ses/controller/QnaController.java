package com.ses.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ses.dto.LogDTO;
import com.ses.dto.PageDTO;
import com.ses.dto.QnaDTO;
import com.ses.dto.SiteListDTO;
import com.ses.service.QService;

@Controller
@Repository
public class QnaController {

	@Autowired
	QService Ser_Q;

	// ����ȭ��
	@RequestMapping("/showQna")
	public String GoMain(HttpServletRequest request, Model model) {
		String Q_NUM = request.getParameter("Qnum");
		int Qnum = Integer.parseInt(Q_NUM);

		QnaDTO dto = Ser_Q.GetQna(Qnum);

		// �� �Ѱ��ֱ�
		model.addAttribute("dto", dto);

		return "/QnaForm";
	}

	// Ű���� �˻�
	@RequestMapping("/searchqna")
	public String SearchedList(HttpServletRequest request, Model model) {
		// parameter�� string���� �� �����ϱ� �������� �� �̽� map���� �����ߵȴ� �̽�
		Map<String, Object> map = new HashMap<String, Object>();
		PageDTO pgDTO = new PageDTO();
		String M_ID = "tytyjacob";
		String bCol = request.getParameter("bCol");
		String bVal = request.getParameter("bVal");
		String pgNum = request.getParameter("pgnum");
		if (pgNum == null) // null�̸� �� ó��
			pgNum = "1";
		// int������
		int pgnum = Integer.parseInt(pgNum);

		if (bCol.equals("TI")) {
			map.put("bVal1", "%" + bVal + "%");
			map.put("bVal2", "%");
		} else if (bCol.equals("WR")) {
			map.put("bVal1", "%");
			map.put("bVal2", "%" + bVal + "%");
		}

		// ��ü �Խñ� ���� ����
		pgDTO.setTotalCnt(Ser_Q.SearchedListCnt(map));
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

		if (bCol.equals("����")) {
			map.put("bVal1", "%" + bVal + "%");
			map.put("bVal2", "%");
		} else if (bCol.equals("�ۼ���")) {
			map.put("bVal1", "%");
			map.put("bVal2", "%" + bVal + "%");
		}
		map.put("startNum", (pgnum - 1) * pgDTO.getContentNum());
		map.put("ContentNum", pgDTO.getContentNum());

		// ����Ʈ ����
		List<QnaDTO> dtos = Ser_Q.SearchList(map);
		
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
		model.addAttribute("bCol", bCol);
		model.addAttribute("bVal", bVal);
		model.addAttribute("before", pgDTO.getStartPage() - 1);
		model.addAttribute("after", pgDTO.getEndPage() + 1);
		model.addAttribute("prev", prev);
		model.addAttribute("pg", pg);
		model.addAttribute("next", next);
		if (pgDTO.getTotalCnt() % pgDTO.getContentNum() > 0)
			model.addAttribute("last", pgDTO.getTotalCnt() / pgDTO.getContentNum() + 1);
		else
			model.addAttribute("last", pgDTO.getTotalCnt() / pgDTO.getContentNum());

		return "/QnaSearched";
	}
}
