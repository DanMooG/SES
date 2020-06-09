package com.ses.service;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.ses.dao.MemberDAO;
import com.ses.dto.MemberDTO;

@Service
public class MemberService implements MService {
	@Inject
	MemberDAO mDAO;

	// ���̵� �ߺ� üũ
	@Override
	public boolean CheckId(String mId) {
		return mDAO.CheckId(mId);
	}

	// ȸ������
	public boolean MJoin(Map<String, Object> map) {
		return mDAO.MJoin(map);
	}

	// ȸ���������� ȭ�� �����ֱ�
	@Override
	public MemberDTO GetMInfo(String m_Id) {
		return mDAO.GetMInfo(m_Id);
	}

	// ȸ����������
	@Override
	public boolean MUpdateInfo(Map<String, Object> map) {
		return mDAO.MUpdateInfo(map);
	}

	// ȸ��Ż��
	@Override
	public boolean MGetOut(String mId) {
		return mDAO.MGetOut(mId);
	}

	// �α���
	@Override
	public MemberDTO MLogin(HttpServletRequest request) {
		MemberDTO dto = mDAO.MLogin(request.getParameter("mId"));

		return dto;
	}

	// �α׾ƿ�
	@Override
	public void logout(HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("document.location.href='index';");
		out.println("</script>");
		out.close();
	}
}
