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

import com.ses.dto.SiteListDTO;
import com.ses.service.SLService;

@Controller
@Repository
public class SiteListController {
	
	@Autowired
	SLService Ser_SL;

	// Ű���� �˻�
	@RequestMapping("/search")
	public String SearchedList(HttpServletRequest request, Model model) {
		// parameter�� string���� �� �����ϱ� �������� �� �̽� map���� �����ߵȴ� �̽�
		Map<String, Object> map = new HashMap<String, Object>();
		//Ű���� ��������
		String keyword = request.getParameter("keyword");
		String kind = request.getParameter("kind");
		String M_ID = "tytyjacob";
		
		map.put("kind", kind);
		map.put("M_ID", M_ID);
		map.put("keyword", "%"+keyword+"%");

		List<SiteListDTO> dto = Ser_SL.SearchList(map);
		
		model.addAttribute("dtos", dto);
		model.addAttribute("kind", kind);
		
		return "/EasySearch";
	}
}
