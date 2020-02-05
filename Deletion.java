package data.java;

import java.sql.*;

public class Deletion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Connection conn = null;
	      Statement stmt = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         conn = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/Bhavya",
	            "postgres", "postgres");
	         stmt = conn.createStatement();
	         String sql = "DROP TABLE employee ";
	         
	         stmt.executeUpdate(sql);
	         
	         
	         
//	         PreparedStatement preparedStatement = conn.prepareStatement(CREATE_TABLE_SQL);
//	         ResultSet resultSet = preparedStatement.executeQuery();
//	         while(resultSet.next()){
//	        	 System.out.print(resultSet.getInt("id")+" ");
//	        	 System.out.println(resultSet.getString("name"));
//	         }
	      } catch (Exception e) 
	      {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Table deleted");

	}

}
