package com.ses.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ses.dto.QnaDTO;
import com.ses.dto.Criteria;
import com.ses.dto.SearchCriteria;

@Repository
public class QnaDAOImpl {		
	@Inject
	private SqlSession sqlSession;
	
	/*
	   // �����ϱ� �� �ۼ�
		@Override
		public void write(QnaDTO qnaDTO) throws Exception {
			sqlSession.insert("qnaMapper.insert", qnaDTO);

		}

		// �����ϱ� ��� ��ȸ
		@Override
		public Qna<QnaDTO> qna(SearchCriteria scri) throws Exception {
			// TODO Auto-generated method stub
			return sqlSession.selectList("qnaMapper.listPage", scri);
		}

		// �����ϱ� �Խù� �� ����
		@Override
		public int qnaCount(SearchCriteria scri) throws Exception {
			// TODO Auto-generated method stub
			return sqlSession.selectOne("qnaMapper.listCount", scri);
		}

		// �����ϱ� ��ȸ
		@Override
		public QnaDTO read(int bid) throws Exception {

			return sqlSession.selectOne("qnaMapper.read", bid);
		}

		// �����ϱ� �Խù� ����
		@Override
		public void qnaupdate(QnaDTO qnaDTO) throws Exception {

			sqlSession.update("qnaMapper.update", qnaDTO);
		}

		// �����ϱ� �Խù� ����
		@Override
		public void delete(int bid) throws Exception {

			sqlSession.delete("qnaMapper.delete", bid);
		}
		*/
	}
