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

import com.ses.dto.QnaDTO;
import com.ses.service.QService;

@Controller
@Repository
public class QnaController {

	@Autowired
	QService Ser_Q;

	// 메인화면
	@RequestMapping("/showQna")
	public String GoMain(HttpServletRequest request, Model model) {
		String Q_NUM = request.getParameter("Qnum");
		int Qnum = Integer.parseInt(Q_NUM);
		
		QnaDTO dto = Ser_Q.GetQna(Qnum);
		
		// 값 넘겨주기
		model.addAttribute("dto", dto);

		return "/QnaForm";
	}
}
