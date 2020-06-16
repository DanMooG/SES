package com.ses.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.activation.DataSource;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ses.dto.QnaDTO;

@Repository
public class QnaDAO {
	@Autowired
	public SqlSessionTemplate temp;
	
	//메인화면에 띄울 4개 가져오기
	public List<QnaDTO> getFour() {
		return temp.selectList("Qmap.GetFour");
	}

	//문의하기 클릭 시 내용 보여주기
	public QnaDTO GetQna(int Qnum) {
		return temp.selectOne("Qmap.GetQna", Qnum);
	}
}
