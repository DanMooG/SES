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

	//메인화면에 띄울 4개 가져오기
	@Override
	public List<QnaDTO> GetFour() {
		return qDAO.getFour();
	}

	//문의하기 클릭 시 내용 보여주기
	@Override
	public QnaDTO GetQna(int Qnum) {
		return qDAO.GetQna(Qnum);
	}
}
