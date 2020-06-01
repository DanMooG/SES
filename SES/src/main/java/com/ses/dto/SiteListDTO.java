package com.ses.dto;

public class SiteListDTO {
	private String M_ID = "";
	private String S_NAME = "";
	private String SL_SITE = "";
	private int SL_YEAR = 0;
	private int SL_MONTH = 0;
	private int SL_DAY = 0;
	
	public SiteListDTO(String m_ID, String s_NAME, String sL_SITE, int sL_YEAR, int sL_MONTH, int sL_DAY) {
		super();
		M_ID = m_ID;
		S_NAME = s_NAME;
		SL_SITE = sL_SITE;
		SL_YEAR = sL_YEAR;
		SL_MONTH = sL_MONTH;
		SL_DAY = sL_DAY;
	}

	public String getM_ID() {
		return M_ID;
	}

	public void setM_ID(String m_ID) {
		M_ID = m_ID;
	}

	public String getS_NAME() {
		return S_NAME;
	}

	public void setS_NAME(String s_NAME) {
		S_NAME = s_NAME;
	}

	public String getSL_SITE() {
		return SL_SITE;
	}

	public void setSL_SITE(String sL_SITE) {
		SL_SITE = sL_SITE;
	}

	public int getSL_YEAR() {
		return SL_YEAR;
	}

	public void setSL_YEAR(int sL_YEAR) {
		SL_YEAR = sL_YEAR;
	}

	public int getSL_MONTH() {
		return SL_MONTH;
	}

	public void setSL_MONTH(int sL_MONTH) {
		SL_MONTH = sL_MONTH;
	}

	public int getSL_DAY() {
		return SL_DAY;
	}

	public void setSL_DAY(int sL_DAY) {
		SL_DAY = sL_DAY;
	}
	
	
	
}
