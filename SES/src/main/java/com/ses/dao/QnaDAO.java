package com.ses.dao;

import java.util.List;

import com.ses.dto.QnaDTO;
import com.ses.dto.Criteria;
import com.ses.dto.SearchCriteria;

public interface QnaDAO {

	// �����ϱ� �� �ۼ�
	public void write(QnaDTO qnaDTO) throws Exception;

	// �����ϱ� ��� ��ȸ
	public List<QnaDTO> qna(SearchCriteria scri) throws Exception;

	// �����ϱ� �Խù� �� ����
	public int qnaCount(SearchCriteria scri) throws Exception;

	// �����ϱ� ��ȸ
	public QnaDTO read(int bid) throws Exception;

	// �����ϱ� �Խù� ����
	public void update(QnaDTO qnaDTO) throws Exception;

	// �����ϱ� �Խù� ����
	public void delete(int bid) throws Exception;

}