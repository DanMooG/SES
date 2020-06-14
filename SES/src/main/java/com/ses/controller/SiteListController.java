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

import com.ses.dto.PageDTO;
import com.ses.dto.SiteListDTO;
import com.ses.service.SLService;

@Controller
@Repository
public class SiteListController {

	@Autowired
	SLService Ser_SL;

	// 키워드 검색
	@RequestMapping("/search")
	public String SearchedList(HttpServletRequest request, Model model) {
		// parameter로 string으로 걍 보내니까 오류난다 이 똬식 map으로 보내야된대 똬식
		Map<String, Object> map = new HashMap<String, Object>();
		// 키워드 가져오기
		String keyword = request.getParameter("keyword");
		String kind = request.getParameter("kind");
		String M_ID = "tytyjacob";

		map.put("kind", kind);
		map.put("M_ID", M_ID);
		map.put("keyword", "%" + keyword + "%");

		// 리스트 내용
		List<SiteListDTO> dtos_origin = Ser_SL.SearchList(map);

		// 값 넘겨주기
		model.addAttribute("dtos", dtos_origin);
		model.addAttribute("kind", kind);

		return "/EasySearch";
	}
}
