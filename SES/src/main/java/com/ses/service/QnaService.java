package com.ses.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ses.dao.QnaDAO;
import com.ses.dto.QnaDTO;
import com.ses.dto.SearchCriteria;

@Service
public class QnaService{
	/*
	@Inject
	private QnaDAO dao;
	
	    // 문의하기 작성
		@Override
		public void write(QnaDTO qnaDTO) throws Exception {
			dao.write(qnaDTO);
		}

		// 문의하기 목록 조회
		@Override
		public List<QnaDTO> qna(SearchCriteria scri) throws Exception {

			return dao.qna(scri);
		}
		
		// 문의하기 게시물  총 갯수
		@Override
		public int qnaCount(SearchCriteria scri) throws Exception {
			// TODO Auto-generated method stub
			return dao.qnaCount(scri);
		}

		// 문의하기 조회
		@Override
		public QnaDTO read(int bid) throws Exception {

			return dao.read(bid);
		}

		// 문의하기 게시물 수정
		@Override
		public void update(QnaDTO qnaDTO) throws Exception {

			dao.update(qnaDTO);
		}

		// 문의하기 게시물 삭제
		@Override
		public void delete(int bid) throws Exception {
			
			dao.delete(bid);
		}
		*/
}
