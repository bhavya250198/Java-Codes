package data.java;


import java.sql.*;

public class NewTable {
	private static final String CREATE_TABLE_SQL =  "CREATE TABLE customer1("
            + "CID SERIAL PRIMARY KEY,"
            + "NAME VARCHAR(45) NOT NULL,"
            +"LASTNAME VARCHAR(45) NOT NULL,"
            + "SALARY INT NOT NULL)";
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
	        stmt.executeUpdate(CREATE_TABLE_SQL);
	         
	         
	         
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
	      System.out.println("Table created");
	}

}
