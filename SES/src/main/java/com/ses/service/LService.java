package com.ses.service;

import java.util.List;
import java.util.Map;

import com.ses.dto.LogDTO;

public interface LService {
	// 게시물 목록 불러오기
	public List<LogDTO> GetLList(Map<String, Object> map);
}
