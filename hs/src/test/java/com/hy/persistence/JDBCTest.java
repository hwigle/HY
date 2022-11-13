package com.hy.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JDBCTest {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {
		
		try(Connection con = 
				DriverManager.getConnection(
                // Oracle19 버전인 경우 => "jdbc:oracle:thin:@localhost:1521:orcl"
                // Oracle11 버전인 경우 => "jdbc:oracle:thin:@localhost:1521:XE"
						"Oracle Database url",
						"자신의 사용자명",
						"사용자 비밀 번호")){
			System.out.println(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
