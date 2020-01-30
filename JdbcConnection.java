package bhavya;
import java.sql.*;


public class JdbcConnection {
	private static final String CREATE_TABLE_SQL =  "CREATE TABLE employee4 ("
             + "UID INT NOT NULL,"
             + "NAME VARCHAR(45) NOT NULL,"
             + "DOB DATE NOT NULL,"
             + "EMAIL VARCHAR(45) NOT NULL,"
             + "PRIMARY KEY (UID))";
   public static void main(String args[]) 
   {
      Connection conn = null;
      Statement stmt = null;
      try {
         Class.forName("org.postgresql.Driver");
         conn = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/postgres",
            "postgres", "postgres");
         
         stmt = conn.createStatement();
        stmt.executeUpdate(CREATE_TABLE_SQL);
         
         
         
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
      System.out.println("Opened database successfully");
   }
}