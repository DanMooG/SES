package com.ses.dto;

public class SignUpDTO {
	private String S_NAME = "";
	private String S_LINK = "";
	private String M_ID = "";
	private boolean S_STATE = false;
	
	public SignUpDTO(String s_NAME, String s_LINK, String m_ID, boolean s_STATE) {
		super();
		S_NAME = s_NAME;
		S_LINK = s_LINK;
		M_ID = m_ID;
		S_STATE = s_STATE;
	}

	public String getS_NAME() {
		return S_NAME;
	}

	public void setS_NAME(String s_NAME) {
		S_NAME = s_NAME;
	}

	public String getS_LINK() {
		return S_LINK;
	}

	public void setS_LINK(String s_LINK) {
		S_LINK = s_LINK;
	}

	public String getM_ID() {
		return M_ID;
	}

	public void setM_ID(String m_ID) {
		M_ID = m_ID;
	}

	public boolean isS_STATE() {
		return S_STATE;
	}

	public void setS_STATE(boolean s_STATE) {
		S_STATE = s_STATE;
	}
	
	
}
