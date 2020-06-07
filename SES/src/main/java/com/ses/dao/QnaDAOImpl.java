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
	   // 문의하기 글 작성
		@Override
		public void write(QnaDTO qnaDTO) throws Exception {
			sqlSession.insert("qnaMapper.insert", qnaDTO);

		}

		// 문의하기 목록 조회
		@Override
		public Qna<QnaDTO> qna(SearchCriteria scri) throws Exception {
			// TODO Auto-generated method stub
			return sqlSession.selectList("qnaMapper.listPage", scri);
		}

		// 문의하기 게시물 총 갯수
		@Override
		public int qnaCount(SearchCriteria scri) throws Exception {
			// TODO Auto-generated method stub
			return sqlSession.selectOne("qnaMapper.listCount", scri);
		}

		// 문의하기 조회
		@Override
		public QnaDTO read(int bid) throws Exception {

			return sqlSession.selectOne("qnaMapper.read", bid);
		}

		// 문의하기 게시물 수정
		@Override
		public void qnaupdate(QnaDTO qnaDTO) throws Exception {

			sqlSession.update("qnaMapper.update", qnaDTO);
		}

		// 문의하기 게시물 삭제
		@Override
		public void delete(int bid) throws Exception {

			sqlSession.delete("qnaMapper.delete", bid);
		}
		*/
	}

