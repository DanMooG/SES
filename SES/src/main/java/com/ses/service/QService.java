package com.ses.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ses.dto.QnaDTO;


@Service
public interface QService {
	
	//����ȭ�鿡 ��� 4�� ��������
	public List<QnaDTO> GetFour();
	
	//�����ϱ� Ŭ�� �� ���� �����ֱ�
	public QnaDTO GetQna(int Qnum);
}
