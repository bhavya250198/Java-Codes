package data.java;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
public class Reading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		 PreparedStatement preparedStatement = null;
		try  
		{  Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Bhavya","postgres", "postgres");
        final File folder = new File("C:\\Users\\A\\Desktop\\React\\Input");
        List<String> result = new ArrayList<>();
        
        search(".*\\.xlsx", folder, result);
        for (String s : result) 
        {
            String str2=" ";
			List<String> r = new ArrayList<String>();
		File file =  new File(s); 
	    preparedStatement = connection.prepareStatement("insert into ird_internship2 values(?,?)");
	  //creating a new file instance  
		FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
		//creating Workbook instance that refers to .xlsx file  
		XSSFWorkbook wb = new XSSFWorkbook(fis);   
		XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
		Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
		while (itr.hasNext())                 
		{  
		Row row = itr.next();  
		Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
		while (cellIterator.hasNext())   
		{  
		
		Cell cell = cellIterator.next(); 
		
		switch (cell.getCellType())               
		{  
		case Cell.CELL_TYPE_STRING:
		String str=(cell.getStringCellValue() + "\t\t\t"); 
		str2+=str+" ";
		break;  
		case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
		double a=cell.getNumericCellValue(); 
		String str3= String.valueOf(a);
		str2+=str3;
		break;  
		default:  
		}  
		}    
		}  
		String f=s.substring(31);
     	
			preparedStatement.setString(1, f);
	 		preparedStatement.setString(2, str2);
	 		int res=preparedStatement.executeUpdate();
	 		if(res==0)
					System.out.println("Student details not inserted");
				else
					System.out.println("Student details inserted");
			
		//	r.add(g);
		//	System.out.println(r);
		} 
		}
		catch (ClassNotFoundException cnf) 
	      {
	         cnf.printStackTrace();
	         System.err.println(cnf.getClass().getName()+": "+cnf.getMessage());
	         System.exit(0);
	      }
      catch (SQLException se) 
	      {
	         se.printStackTrace();
	         System.err.println(se.getClass().getName()+": "+se.getMessage());
	         System.exit(0);
	      }
      catch (Exception e) 
	      {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
      
      finally
      {
      	try
      	{
      		if(preparedStatement != null)
      			preparedStatement.close();
      	}
      	 catch (SQLException se) 
 	      {
 	         se.printStackTrace();
 	         System.err.println(se.getClass().getName()+": "+se.getMessage());
 	         System.exit(0);
 	      }
      	try
      	{
      		if(connection!= null)
      			connection.close();
      	}
      	 catch (SQLException se1) 
 	      {
 	         se1.printStackTrace();
 	         System.err.println(se1.getClass().getName()+": "+se1.getMessage());
 	         System.exit(0);
 	      }
      }


}
	   public static void search(final String pattern, final File folder, List<String> result) {
	        for (final File f : folder.listFiles()) {

	            if (f.isDirectory()) {
	                search(pattern, f, result);
	            }

	            if (f.isFile()) {
	                if (f.getName().matches(pattern)) {
	                    result.add(f.getAbsolutePath());
	                }
	                
	            }

	        }
	    }

}