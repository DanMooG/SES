package com.ses.dto;

public class QnaDTO {
	private String Q_TITLE = "";
	private String M_ID = "";
	private int Q_PWD = 0;
	private String Q_CONTENT = "";
	
	public QnaDTO(String q_TITLE, String m_ID, int q_PWD, String q_CONTENT) {
		super();
		Q_TITLE = q_TITLE;
		M_ID = m_ID;
		Q_PWD = q_PWD;
		Q_CONTENT = q_CONTENT;
	}
	
	public String getQ_TITLE() {
		return Q_TITLE;
	}
	public void setQ_TITLE(String q_TITLE) {
		Q_TITLE = q_TITLE;
	}
	public String getM_ID() {
		return M_ID;
	}
	public void setM_ID(String m_ID) {
		M_ID = m_ID;
	}
	public int getQ_PWD() {
		return Q_PWD;
	}
	public void setQ_PWD(int q_PWD) {
		Q_PWD = q_PWD;
	}
	public String getQ_CONTENT() {
		return Q_CONTENT;
	}
	public void setQ_CONTENT(String q_CONTENT) {
		Q_CONTENT = q_CONTENT;
	}
	
	
}
