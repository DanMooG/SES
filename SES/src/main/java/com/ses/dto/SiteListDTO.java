package com.ses.dto;

public class SiteListDTO {
	private String SL_NAME = "";
    private String SL_SITE = "";
    private String M_ID = "";
    private String SU_KIND = "";
    private int SL_YEAR = 0;
    private int SL_MONTH = 0;
    private int SL_DAY = 0;
    private String SL_STATE = "";
    
    public SiteListDTO() {
    	
    }
	
    public SiteListDTO(String sL_NAME, String sL_SITE, String m_ID, String sU_KIND, int sL_YEAR, int sL_MONTH,
			int sL_DAY, int sL_STATE) {
		super();
		SL_NAME = sL_NAME;
		SL_SITE = sL_SITE;
		M_ID = m_ID;
		SU_KIND = sU_KIND;
		SL_YEAR = sL_YEAR;
		SL_MONTH = sL_MONTH;
		SL_DAY = sL_DAY;
		if(sL_STATE == 0) {
			SL_STATE = "해지";
		} else {
			SL_STATE = "연결";
		}
	}

	public String getSL_NAME() {
		return SL_NAME;
	}

	public void setSL_NAME(String sL_NAME) {
		SL_NAME = sL_NAME;
	}

	public String getSL_SITE() {
		return SL_SITE;
	}

	public void setSL_SITE(String sL_SITE) {
		SL_SITE = sL_SITE;
	}

	public String getM_ID() {
		return M_ID;
	}

	public void setM_ID(String m_ID) {
		M_ID = m_ID;
	}

	public String getSU_KIND() {
		return SU_KIND;
	}

	public void setSU_KIND(String sU_KIND) {
		SU_KIND = sU_KIND;
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

	public String getSL_STATE() {
		return SL_STATE;
	}

	public void setSL_STATE(int sL_STATE) {
		if(sL_STATE == 0) {
			SL_STATE = "해지";
		} else {
			SL_STATE = "연결";
		}
	}
    
    
    
}