package com.ses.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ses.dto.QnaDTO;


@Service
public interface QService {
	
	//메인화면에 띄울 4개 가져오기
	public List<QnaDTO> GetFour();
	
	//문의하기 클릭 시 내용 보여주기
	public QnaDTO GetQna(int Qnum);
}
