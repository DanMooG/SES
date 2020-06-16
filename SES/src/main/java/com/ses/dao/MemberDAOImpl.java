package com.ses.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ses.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Autowired
	public SqlSessionTemplate temp;
	
	@Inject
	private SqlSession sqlSession;

	// ���̵� �ߺ� üũ
	@Override
	public boolean CheckId(String M_ID) {
		String rs = temp.selectOne("Mmap.MCheckId", M_ID);
		if (rs == null)
			return true;
		else
			return false;
	}

	// ȸ������
	@Override
	public boolean MJoin(Map<String, Object> map) {
		int rs = temp.insert("Mmap.MJoin", map);
		if (rs == 1)
			return true;
		else
			return false;
	}
	
	// ȸ���������� ȭ�� �����ֱ�
	@Override
	public MemberDTO GetMInfo(String M_Id) {
		List<MemberDTO> dtos = temp.selectList("Mmap.GetMInfo", M_Id);
		return dtos.get(0);
	}

	// ȸ����������
	@Override
	public boolean MUpdateInfo(Map<String, Object> map) {
		int rs = temp.update("Mmap.MUpdateInfo", map);
		if (rs == 1)
			return true;
		else
			return false;
	}	

	// �α���
	@Override
	public MemberDTO MLogin(String M_Id) {
		return sqlSession.selectOne("Mmap.MLogin", M_Id);
	}

}