package com.ses.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ses.dao.QnaDAO;

@Service
public class QnaService implements QService{
	@Inject
	QnaDAO qDAO;
}
