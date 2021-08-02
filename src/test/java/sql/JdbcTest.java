package sql;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {

    @Test
    void 정상적인_입력_Not_Secure() throws SQLException {

        JdbcSetting jdbcSetting = new JdbcSetting();
        jdbcSetting.getConnection();

        String title = "test1";
        ResultSet rs = jdbcSetting.getBoardByName_NotSecure(title);
        // 제목이 "test1"인 게시판의 데이터를 얻는다.
        while (rs.next()) {
            System.out.println(rs.getString(2)); // testest
        }

        jdbcSetting.closeConnection();
    }

    @Test
    void 잘못된_입력_Not_Secure() throws SQLException {

        JdbcSetting jdbcSetting = new JdbcSetting();
        jdbcSetting.getConnection();

        String title = "test1' or 'test1'='test1";
        ResultSet rs = jdbcSetting.getBoardByName_NotSecure(title);
        // 테이블의 모든 내용이 조회된다.
        while (rs.next()) {
            System.out.println(rs.getString(2));
        }
        /*
            testest
            test
            test3
            test4 내용
            테스트5
         */
        jdbcSetting.closeConnection();
    }

    @Test
    void 잘못된_입력__Secure() throws SQLException {

        JdbcSetting jdbcSetting = new JdbcSetting();
        jdbcSetting.getConnection();

        String title = "test1";
        ResultSet rs = jdbcSetting.getBoardByName_Secure(title);
        // 제목이 "test1"인 게시판의 데이터를 얻는다.
        while (rs.next()) {
            System.out.println(rs.getString(2)); // testest
        }

        jdbcSetting.closeConnection();
    }

    @Test
    void 정상적인_입력_Secure() throws SQLException {

        JdbcSetting jdbcSetting = new JdbcSetting();
        jdbcSetting.getConnection();

        String title = "test1' or 'test1'='test1";
        ResultSet rs = jdbcSetting.getBoardByName_Secure(title);
        while (rs.next()) {
            System.out.println(rs.getString(2)); // 출력 X
        }

        jdbcSetting.closeConnection();
    }
}
