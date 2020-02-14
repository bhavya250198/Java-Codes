package data.java;
import java.sql.*;
public class Insertion {
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
       //stmt.executeUpdate(CREATE_TABLE_SQL);
        
     /* String  sql = "INSERT INTO customer " + "VALUES('6','Bilal','Saeed','10')";
        stmt.executeUpdate(sql);*/
      String sql="COPY customer(cid,name,lastname,salary) FROM 'C:\\Users\\A\\OneDrive\\Documents\\Books.xlsx' DELIMITER ',' CSV HEADER";
      			stmt.executeUpdate(sql);
      //        PreparedStatement preparedStatement = conn.prepareStatement(CREATE_TABLE_SQL);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while(resultSet.next()){
//       	 System.out.print(resultSet.getInt("id")+" ");
//       	 System.out.println(resultSet.getString("name"));
//        }
     } catch (Exception e) 
     {
        e.printStackTrace();
        System.err.println(e.getClass().getName()+": "+e.getMessage());
        System.exit(0);
     }
     System.out.println("Inserted");
  }
}


