package com.ses.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

public class QnaDAO {
	Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    private DataSource dataSource;
    
    public QnaDAO() {
        try {
            Context context = new InitialContext();
            dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private static QnaDAO instance = new QnaDAO();
    
    public static QnaDAO getInstance() {
        return instance;
    }
}
