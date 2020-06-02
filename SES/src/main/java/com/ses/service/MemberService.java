package com.ses.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ses.dao.MemberDAO;

@Service
public class MemberService implements MService{
	@Inject
	MemberDAO mDAO;
}
