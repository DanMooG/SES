package com.ses.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ses.dao.LogDAO;
import com.ses.dto.LogDTO;

@Service
public class LogService implements LService{
	@Inject
	LogDAO lDAO;

	@Override
	public List<LogDTO> GetLList(Map<String, Object> map) {
		return lDAO.GetLList(map);
	}

	@Override
	public int SearchedListCnt(Map<String, Object> map) {
		return lDAO.SearchedListCnt(map);
	}

	@Override
	public int PageCnt(Map<String, Object> map) {
		return lDAO.ListCnt(map);
	}

	@Override
	public List<LogDTO> SearchList(Map<String, Object> map) {
		return lDAO.SearchList(map);
	}
}
