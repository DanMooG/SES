package com.ses.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ses.dao.LogDAO;

@Service
public class LogService implements LService{
	@Inject
	LogDAO lDAO;
}
