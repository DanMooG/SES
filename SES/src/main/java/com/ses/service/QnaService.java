package com.ses.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ses.dao.QnaDAOImpl;

@Service
public class QnaService implements QService{
	@Inject
	QnaDAOImpl qDAO;
}
