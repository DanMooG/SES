package com.ses.dto;

public class QnaDTO {
	private int Q_NUM = 0;
	private String Q_TITLE = "";
	private String M_ID = "";
	private int Q_PWD = 0;
	private String Q_CONTENT = "";
	private String Q_REPLY = "";
	
	public QnaDTO() {}
	
	public QnaDTO(String q_TITLE, String m_ID, int q_PWD, String q_CONTENT, String q_REPLY) {
		super();
		Q_TITLE = q_TITLE;
		M_ID = m_ID;
		Q_PWD = q_PWD;
		Q_CONTENT = q_CONTENT;
		Q_REPLY = q_REPLY;
	}
	

	public int getQ_NUM() {
		return Q_NUM;
	}

	public void setQ_NUM(int q_NUM) {
		Q_NUM = q_NUM;
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

	public String getQ_REPLY() {
		return Q_REPLY;
	}

	public void setQ_REPLY(String q_REPLY) {
		Q_REPLY = q_REPLY;
	}
}
/*
CREATE TABLE `qna` (
	`Q_NUM` INT(100) NOT NULL AUTO_INCREMENT,
	`Q_TITLE` VARCHAR(100) NULL DEFAULT NULL,
	`M_ID` VARCHAR(20) NULL DEFAULT NULL,
	`Q_PWD` INT(5) NULL DEFAULT NULL,
	`Q_CONTENT` BLOB NULL DEFAULT NULL,
	`Q_REPLY` BLOB NULL DEFAULT NULL,
	PRIMARY KEY (`Q_NUM`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=14
;
*/