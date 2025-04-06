//package com.example.Project;
//
//import java.sql.Connection;
//
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//@ComponentScan("com.example.Project")
//@SpringBootApplication
//public class ProjectApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(ProjectApplication.class, args);
//		connect();
//	}
//	public static void connect() {
//		String url="jdbc:mysql://localhost:3306/myproject";
//		String user="root";
//		String password="root";
//		
//		try (Connection conn=DriverManager.getConnection(url, user, password)){
//			if(conn!=null) {
//				System.out.println("Connection is Successfull!");
//			}		
//		}
//		catch(SQLException e) {
//			System.out.println("Connection is Unsuccessfull!" + e.getMessage());
//		}
//	}
//
//}
package com.example.Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@PostConstruct
	public void connect() {
		String url = "jdbc:mysql://localhost:3306/myproject";
		String user = "root";
		String password = "root";

		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			System.out.println("Connection Successful!");
		} catch (SQLException e) {
			System.err.println("Connection Failed! " + e.getMessage());
		}
	}
}
