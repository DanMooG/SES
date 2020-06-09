package com.ses.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ses.dao.SiteListDAO;
import com.ses.dto.SiteListDTO;

@Service
public class SiteListService implements SLService{
	@Inject
	SiteListDAO slDAO;

	@Override
	public List<SiteListDTO> GetSLList(Map<String, Object> map) {
		return slDAO.GetSLList(map);
	}

	@Override
	public List<SiteListDTO> SearchList(Map<String, Object> map) {
		return slDAO.SearchList(map);
	}
	
	
}
