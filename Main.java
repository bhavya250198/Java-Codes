package data.java;

import data.java.Employees;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 class  Main
 {
	 public static void main(String args[])
	 {
		 ArrayList<Employees> employeeslist = new ArrayList<Employees>();
		 try
		 {
			 Class.forName("org.postgresql.Driver");
			 Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Bhavya","postgres","postgres");
			 Statement s = conn.createStatement();
			 String sql = "select * from customer";
			 ResultSet rs= s.executeQuery(sql);
			 while(rs.next())
			 {
				 Employees e = new Employees();
				 e.setcustomerid(rs.getInt("cid"));
				 e.setcustomername(rs.getString("name"));
				 e.settcustomerlast(rs.getString("lastname"));
				 e.setcustomersalary(rs.getInt("salary"));
				 employeeslist.add(e);
			 }
			 int a = employeeslist.size();
			 for(int i =0;i<a;i++)
			 {
	            System.out.print(employeeslist.get(i).getcustomerid()+" ");
	            System.out.print(employeeslist.get(i).getcustomername()+" ");
	            System.out.print(employeeslist.get(i).getcustomerlast()+" ");
	            System.out.print(employeeslist.get(i).getcustomersalary()+" ");
	            System.out.print(employeeslist.get(i));
				System.out.println();
			 } 
			 }
		 catch (Exception e) {
		            System.err.println("Got an exception! ");
		            System.err.println(e.getMessage());
		        }
		 }
	 }
 


