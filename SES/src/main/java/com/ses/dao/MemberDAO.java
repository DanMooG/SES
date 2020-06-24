package com.ses.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.activation.DataSource;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ses.dto.MemberDTO;

@Repository
public class MemberDAO {
	@Autowired
	public SqlSessionTemplate temp;

	@Inject
	private SqlSession sqlSession;

	// �α���
	public MemberDTO MLogin(String mId) {
		return sqlSession.selectOne("Mmap.MLogin", mId);
	}

	// ���̵� �ߺ� üũ
	public boolean CheckId(String mId) {
		String rs = temp.selectOne("Mmap.MCheckId", mId);
		if (rs == null)
			return true;
		else
			return false;
	}

	// ȸ������
	public boolean MJoin(Map<String, Object> map) {
		int rs = temp.insert("Mmap.MJoin", map);
		if (rs == 1)
			return true;
		else
			return false;
	}
}