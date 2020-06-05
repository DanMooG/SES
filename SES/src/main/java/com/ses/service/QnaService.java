package com.ses.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ses.dao.QnaDAO;
import com.ses.dto.QnaDTO;
import com.ses.dto.SearchCriteria;

@Service
public class QnaService implements QService{
	@Inject
	private QnaDAO dao;
	
	    // �����ϱ� �ۼ�
		@Override
		public void write(QnaDTO qnaDTO) throws Exception {
			dao.write(qnaDTO);
		}

		// �����ϱ� ��� ��ȸ
		@Override
		public List<QnaDTO> qna(SearchCriteria scri) throws Exception {

			return dao.qna(scri);
		}
		
		// �����ϱ� �Խù�  �� ����
		@Override
		public int qnaCount(SearchCriteria scri) throws Exception {
			// TODO Auto-generated method stub
			return dao.qnaCount(scri);
		}

		// �����ϱ� ��ȸ
		@Override
		public QnaDTO read(int bid) throws Exception {

			return dao.read(bid);
		}

		// �����ϱ� �Խù� ����
		@Override
		public void update(QnaDTO qnaDTO) throws Exception {

			dao.update(qnaDTO);
		}

		// �����ϱ� �Խù� ����
		@Override
		public void delete(int bid) throws Exception {
			
			dao.delete(bid);
		}
}