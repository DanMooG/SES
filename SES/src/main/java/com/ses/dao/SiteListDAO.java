package com.ses.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import javax.activation.DataSource;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ses.dto.SiteListDTO;

@Repository
public class SiteListDAO {
	@Autowired
	public SqlSessionTemplate temp;

	// list 가져와
	public List<SiteListDTO> GetSLList(Map<String, Object> map) {
		return temp.selectList("SLmap.SLList", map);
	}

	// list 검색
	public List<SiteListDTO> SearchList(Map<String, Object> map) {
		return temp.selectList("SLmap.Search", map);
	}

	// 전체 페이지 개수 구하기
	public int SearchedListCnt(Map<String, Object> map) {
		return temp.selectOne("SLmap.SearchCnt", map);
	}

	// 전체 페이지 개수 구하기
	public int ListCnt(Map<String, Object> map) {
		return temp.selectOne("SLmap.ListCnt", map);
	}
}