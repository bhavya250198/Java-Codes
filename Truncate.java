package data.java;

import java.sql.*;

public class Truncate {
	 public static void main(String args[]) 
	   {
	  Connection conn = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         conn = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/Bhavya",
            "postgres", "postgres");
         stmt = conn.createStatement();
       
         
         
         
//         PreparedStatement preparedStatement = conn.prepareStatement(CREATE_TABLE_SQL);
//         ResultSet resultSet = preparedStatement.executeQuery();
//         while(resultSet.next()){
//        	 System.out.print(resultSet.getInt("id")+" ");
//        	 System.out.println(resultSet.getString("name"));
//         }
      } catch (Exception e) 
      {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      try {
    	  
    	  stmt = conn.createStatement();
    	 
    	 
    	  /* TRUNCATE is faster than DELETE since 
    	 
    	   * it does not generate rollback information and does not 
    	 
    	   * fire any delete triggers
    	 
    	   */
    	 
    	  stmt.executeUpdate("TRUNCATE employee");
    	 
    	 
    	  System.out.println("Successfully truncated test_table");
    	 
    	    } catch (SQLException e) {
    	 
    	  System.out.println("Could not truncate test_table " + e.getMessage());
    	    }
     

}
}
