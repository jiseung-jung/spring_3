package com.jiseung.s3.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

@Component
public class DBConnector {
	
	public Connection getConnect() throws Exception {
		//1. 연결정보 4가지 입력
		
				String user = "hr";
				String password = "tiger";
				String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
				String driver = "oracle.jdbc.driver.OracleDriver";
				
		//2. driver를 메모리에 로딩
				Class.forName(driver);
				System.out.println("=====Driver Loading Complete=====");
				
		//3. 로그인 후 Connection
				
				Connection con = DriverManager.getConnection(url, user, password);
				System.out.println("로그인 성공");
				System.out.println(con);
				
				return con;
		
	}

}
