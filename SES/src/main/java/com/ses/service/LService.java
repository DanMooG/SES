package com.ses.service;

import java.util.List;
import java.util.Map;

import com.ses.dto.LogDTO;

public interface LService {
	// �Խù� ��� �ҷ�����
	public List<LogDTO> GetLList(Map<String, Object> map);
}
