package src.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.RequestDispatcher;

import src.pojos.User;

public class RegisterHelper {
	public void registerUser(String fname, String lname, String address, String city,String username, String password)
	{
		
		//String temp="test";
		
		try{
		
			
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SHA2","oracle123");
			
			PreparedStatement ps=connection.prepareStatement("INSERT INTO USERS(FirstName,LastName,Address,City,Username,Password) VALUES (?,?,?,?,?,?)");
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, address);
			ps.setString(4, city);
			ps.setString(5, username);
			ps.setString(6, password);
			ResultSet rs= ps.executeQuery();
			
			
			
		}catch(SQLException e){
				System.out.println(e.getClass().getName()+": "+e.getMessage());
				//user= new User(100,"Genel","Pande");
				
				
			}
		
		
		}
	} 


