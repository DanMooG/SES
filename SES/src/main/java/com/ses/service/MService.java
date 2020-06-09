package com.ses.service;

import javax.servlet.http.HttpServletRequest;

import com.ses.dto.MemberDTO;

public interface MService {

	MemberDTO MLogin(HttpServletRequest request);

}
