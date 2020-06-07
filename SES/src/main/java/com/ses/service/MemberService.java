package com.ses.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.ses.dao.MemberDAO;
import com.ses.dto.MemberDTO;

@Service
public class MemberService implements MService {
   @Inject
   MemberDAO mDAO;

   // ·Î±×ÀÎ
   @Override
   public MemberDTO MLogin(HttpServletRequest request) {
      MemberDTO dto = mDAO.MLogin(request.getParameter("M_ID"));

      return dto;
   }
}