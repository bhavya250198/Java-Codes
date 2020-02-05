package data.java;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Fileexpo 
{
	public static void main(String[] args)
	{ 	String filename="C:\\Users\\A\\OneDrive\\Documents\\Bhavya.csv";
		try
		{
			FileWriter fw = new FileWriter(filename);
		Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Bhavya","postgres","postgres");
        String query = "SELECT * FROM customer ";
        Statement  s = conn.createStatement();
        ResultSet rs=s.executeQuery(query);
        while (rs.next()) {
            fw.append( rs.getString(1));
            fw.append(',');
            fw.append(rs.getString(2));
            fw.append(',');
            fw.append(rs.getString(3));
            fw.append(',');
            fw.append( rs.getString(4));
            fw.append('\n');
           }
        fw.flush();
        fw.close();
        conn.close();
        System.out.println("CSV File is created successfully.");
         
        //For comma separated file
		}
        catch (Exception e) {
            e.printStackTrace();
        }
       
         
   
        }
    
    }
     
     
