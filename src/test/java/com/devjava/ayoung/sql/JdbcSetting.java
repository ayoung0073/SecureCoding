package com.devjava.ayoung.sql;

import java.sql.*;

public class JdbcSetting {

    Connection con;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;

    String url = "jdbc:mysql://localhost:3306/test";
    String id = "root";
    String pw = "33366666622";

    public JdbcSetting() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");    // 드라이버 로딩
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getConnection() {
        try {
            // 커넥션을 가져온다.
            con = DriverManager.getConnection(url, id, pw);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ResultSet getBoardByName_NotSecure(String title) throws SQLException {
        String sql = "SELECT title, content FROM board WHERE title = '" + title + "'";
        stmt = con.createStatement();

        // 외부로부터 입력받은 값이 검증 또는 처리 없이 쿼리로 수행되어 안전하지 않다.
        rs = stmt.executeQuery(sql);
        return rs;
    }

    public ResultSet getBoardByName_Secure(String title) throws SQLException {
        // 1. 사용자에 의해 외부로부터 입력받은 값은 안전하지 않을 수 있으므로,
        //    PreparedStatement 사용을 위해 ? 문자로 바인딩 변수를 사용한다.
        String sql = "SELECT title, content FROM board WHERE title = ?";

        // 2. PreparedStatement 사용한다.
        pstmt = con.prepareStatement(sql);

        // 3.PreparedStatement 객체를 상수 스트링으로 생성하고, 파라미터 부분을 setString등의 메서드로 설정하여 안전하다.
        pstmt.setString(1, title);

        rs = pstmt.executeQuery();
        return rs;
    }

    public void closeConnection() {
        try {
            con.close();
            rs.close();
            if (pstmt != null) pstmt.close();
            if (stmt != null) stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}