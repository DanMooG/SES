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

import com.ses.dto.LogDTO;

@Repository
public class LogDAO {
	@Autowired
	public SqlSessionTemplate temp;

	// list °¡Á®¿Í
	public List<LogDTO> GetLList(Map<String, Object> map) {
		return temp.selectList("Lmap.LList", map);
	}
}