package com.ses.service;

import java.util.List;

import com.ses.dto.QnaDTO;
import com.ses.dto.Criteria;
import com.ses.dto.SearchCriteria;

public interface QService {

	// 문의하기 작성
	public void write(QnaDTO qnaDTO) throws Exception;

	// 문의하기 목록 조회
	public List<QnaDTO> qna(SearchCriteria scri) throws Exception;
	
	// 문의하기  게시물 총 갯수
	public int qnaCount(SearchCriteria scri) throws Exception;
	
	// 문의하기 조회
	public QnaDTO read(int bid) throws Exception;
	
	// 문의하기 게시물 수정
	public void update(QnaDTO qnaDTO) throws Exception;
	
	// 문의하기 게시물 삭제
	public void delete(int bid) throws Exception;
	
}

