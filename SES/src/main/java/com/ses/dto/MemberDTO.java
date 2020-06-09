package com.ses.dto;

public class MemberDTO {
    private String M_ID = "";
    private String M_PW = "";
    private String M_NAME = "";
    private String M_EMAIL1 = "";
    private String M_EMAIL2 = "";
    private int M_TEL1 = 0;
    private int M_TEL2 = 0;
    private int M_TEL3 = 0;
    private int M_BIRTH1 = 0;
    private int M_BIRTH2 = 0;
    private int M_BIRTH3 = 0;
    
    public MemberDTO(String m_ID, String m_PW, String m_NAME, String m_EMAIL1, String m_EMAIL2, int m_TEL1, int m_TEL2,
            int m_TEL3, int m_BIRTH1, int m_BIRTH2, int m_BIRTH3) {
        super();
        M_ID = m_ID;
        M_PW = m_PW;
        M_NAME = m_NAME;
        M_EMAIL1 = m_EMAIL1;
        M_EMAIL2 = m_EMAIL2;
        M_TEL1 = m_TEL1;
        M_TEL2 = m_TEL2;
        M_TEL3 = m_TEL3;
        M_BIRTH1 = m_BIRTH1;
        M_BIRTH2 = m_BIRTH2;
        M_BIRTH3 = m_BIRTH3;
    }

    public String getM_ID() {
        return M_ID;
    }

    public void setM_ID(String m_ID) {
        M_ID = m_ID;
    }

    public String getM_PW() {
        return M_PW;
    }

    public void setM_PW(String m_PW) {
        M_PW = m_PW;
    }

    public String getM_NAME() {
        return M_NAME;
    }

    public void setM_NAME(String m_NAME) {
        M_NAME = m_NAME;
    }

    public String getM_EMAIL1() {
        return M_EMAIL1;
    }

    public void setM_EMAIL1(String m_EMAIL1) {
        M_EMAIL1 = m_EMAIL1;
    }

    public String getM_EMAIL2() {
        return M_EMAIL2;
    }

    public void setM_EMAIL2(String m_EMAIL2) {
        M_EMAIL2 = m_EMAIL2;
    }

    public int getM_TEL1() {
        return M_TEL1;
    }

    public void setM_TEL1(int m_TEL1) {
        M_TEL1 = m_TEL1;
    }

    public int getM_TEL2() {
        return M_TEL2;
    }

    public void setM_TEL2(int m_TEL2) {
        M_TEL2 = m_TEL2;
    }

    public int getM_TEL3() {
        return M_TEL3;
    }

    public void setM_TEL3(int m_TEL3) {
        M_TEL3 = m_TEL3;
    }

    public int getM_BIRTH1() {
        return M_BIRTH1;
    }

	public int getM_BIRTH2() {
		return M_BIRTH2;
	}

	public void setM_BIRTH2(int m_BIRTH2) {
		M_BIRTH2 = m_BIRTH2;
	}

	public int getM_BIRTH3() {
		return M_BIRTH3;
	}

	public void setM_BIRTH3(int m_BIRTH3) {
		M_BIRTH3 = m_BIRTH3;
	}

	public void setM_BIRTH1(int m_BIRTH1) {
		M_BIRTH1 = m_BIRTH1;
	}
}

/*
CREATE TABLE `member` (
	`M_ID` VARCHAR(20) NULL DEFAULT NULL,
	`M_PW` VARCHAR(20) NULL DEFAULT NULL,
	`M_NAME` VARCHAR(20) NULL DEFAULT NULL,
	`M_EMAIL1` VARCHAR(40) NULL DEFAULT NULL,
	`M_EMAIL2` VARCHAR(40) NULL DEFAULT NULL,
	`M_TEL1` INT(11) NOT NULL DEFAULT 0,
	`M_TEL2` INT(11) NOT NULL DEFAULT 0,
	`M_TEL3` INT(11) NOT NULL DEFAULT 0,
	`M_BIRTH1` INT(11) NOT NULL DEFAULT 0,
	`M_BIRTH2` INT(11) NOT NULL DEFAULT 0,
	`M_BIRTH3` INT(11) NOT NULL DEFAULT 0
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
*/