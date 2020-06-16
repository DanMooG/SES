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
	
	//����ȭ�鿡 ��� 4�� ��������
	public List<QnaDTO> getFour() {
		return temp.selectList("Qmap.GetFour");
	}

	//�����ϱ� Ŭ�� �� ���� �����ֱ�
	public QnaDTO GetQna(int Qnum) {
		return temp.selectOne("Qmap.GetQna", Qnum);
	}
}
