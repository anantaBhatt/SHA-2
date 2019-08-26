package src.helpers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.pojos.*;


public class UserHelper {

	//	private PreparedStatement authenticateUserStatement;
		
				
		public User authenticateUser(String username, String password)
		{
			User user=null;
			//String temp="test";
			
			try{
			
				
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SHA2","oracle123");
				
				PreparedStatement ps=connection.prepareStatement("select * from Users where username=? and password=? ");
				ps.setString(1, username);
				ps.setString(2, password);
				ResultSet rs= ps.executeQuery();
				
				if(rs.next()){
					user= new User(rs.getInt("user_id"),rs.getString("username"),rs.getString("password"));
					return user;
							
				}else
				{	
					
					return user;
					
				}
			}catch(SQLException e){
					System.out.println(e.getClass().getName()+": "+e.getMessage());
					//user= new User(100,"Genel","Pande");
					return user;
					
				}
			
			
			}
		} 
