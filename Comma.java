package data.java;
import java.io.*;
import java.sql.*;
 
public class Comma {
 
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/Bhavya";
        String username = "postgres";
        String password = "postgres";
 
        String csvFilePath = "C:\\Users\\A\\OneDrive\\Documents\\Salaries.csv";
 
        int batchSize = 20;
 
        Connection connection = null;
 
        try {
 
            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);
 
            String sql = "INSERT INTO customer1 (cid, name, lastname, salary) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
 
            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;
 
            int count = 0;
 
            lineReader.readLine(); // skip header line
 
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String cid= data[0];
                String name = data[1];
                String lastname = data[2];
                String salary = data[3];
                int  pcid = Integer.parseInt(cid);
                statement.setInt(1,pcid);
 
                statement.setString(2, name);
                statement.setString(3, lastname);
                int  psalary = Integer.parseInt(salary);
                statement.setInt(4,psalary);
                statement.addBatch();
 
                if (count % batchSize == 0) {
                    statement.executeBatch();
                }
            }
 
            lineReader.close();
 
            // execute the remaining queries
            statement.executeBatch();
 
            connection.commit();
            connection.close();
 
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
 
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
 
    }
}

