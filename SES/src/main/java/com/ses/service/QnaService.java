package com.ses.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ses.dao.QnaDAO;
import com.ses.dto.QnaDTO;

@Service
public class QnaService implements QService{
	@Inject
	QnaDAO qDAO;

	//����ȭ�鿡 ��� 4�� ��������
	@Override
	public List<QnaDTO> GetFour() {
		return qDAO.getFour();
	}

	//�����ϱ� Ŭ�� �� ���� �����ֱ�
	@Override
	public QnaDTO GetQna(int Qnum) {
		return qDAO.GetQna(Qnum);
	}
}
