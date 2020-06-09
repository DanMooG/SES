package com.ses.service;

import java.util.List;
import java.util.Map;

import com.ses.dto.SiteListDTO;

public interface SLService {
	// 게시물 목록 불러오기
	public List<SiteListDTO> GetSLList(Map<String, Object> map);
	
	// 게시물 검색
	public List<SiteListDTO> SearchList(Map<String, Object> map);
}
