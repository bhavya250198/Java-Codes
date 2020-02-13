package data.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Source {

	public static void main(String[] args) throws IOException {
		String str2="";
		// TODO Auto-generated method stub
		Connection connection = null;
		 PreparedStatement preparedStatement = null;
		 
		 try
		 {
		 Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Bhavya","postgres", "postgres");
		String s="C:\\Users\\A\\Desktop\\React\\Input\\Acid,Acetic-Subst1446.xlsx";
		File file = new File(s); 
		 preparedStatement = connection.prepareStatement("insert into ird_internship4 values(?,?,?,?,?,?,?,?)");
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
		Row row= sheet.getRow(1);
		int colCount= row.getLastCellNum();
		String str5=" ";
		for(int i=1;i<colCount;i++)
		   {
			Cell cell =row.getCell(i);
			String str4 = String.valueOf(cell);
			   str5 += str4;
			
		}
		Row row2= sheet.getRow(15);                              //Analytical Specifications
		int colCount2 =row2.getLastCellNum();
		String str6=" ";
		for(int i=0;i<colCount;i++)
		   {
			Cell cell =row2.getCell(i);
			String str4 = String.valueOf(cell);
			   str6 += str4;
			
		}
		String str12=" ";
		String str13=" ";
		int batchSize = 20;
		for(int i=17;i<=20;i++)
		{
			
		int count=0;
		preparedStatement.setString(1,f);
		preparedStatement.setString(2,str5);
		Row row1= sheet.getRow(i);
		int colCount1= row1.getLastCellNum();
		
		preparedStatement.setString(3,str6);
		for(int j=0;j<colCount1;j++)
		   {		
			if(j==0)
			{
				Cell cell = row1.getCell(j);
				String str7= String.valueOf(cell);
				preparedStatement.setString(4,str7);
			}
			if(j==1)
			{
				Cell cell1 = row1.getCell(j);
				String str8= String.valueOf(cell1);
				preparedStatement.setString(5,str8);
			}
			if(j==(colCount1-5))
			{	for(int k=j;k<(colCount1-2);k++)
			{
				Cell cell2 = row1.getCell(j);
			String str9= String.valueOf(cell2);
					str12+=str9;
			}
			preparedStatement.setString(6,str12);
			}
			if(j==(colCount1)-2)
			{
			Cell cell3 = row1.getCell(j);
			String str10= String.valueOf(cell3);
			preparedStatement.setString(7,str10);
			}
			if((j==(colCount1)-1))
			{
			Cell cell4 = row1.getCell(j);
			String str11= String.valueOf(cell4);
			preparedStatement.setString(8,str11);
			}
			
			}
		preparedStatement.addBatch();
         
         if (count % batchSize == 0) {
            preparedStatement.executeBatch();
		   }
		
         														/*	int res=preparedStatement.executeUpdate();
 																		if(res==0)
																		System.out.println("Student details not inserted");
																				else
																		System.out.println("Student details inserted");*/
		}
		String str14= "";
		for(int i=30;i<=37;i++)
		{
			
		int count=0;
		preparedStatement.setString(1,f);
		preparedStatement.setString(2,str5);
		Row row1= sheet.getRow(i);
		int colCount1= row1.getLastCellNum();
		
		preparedStatement.setString(3,str6);
		for(int j=0;j<colCount1;j++)
		   {		
				if(j==0)
				{
					Cell cell = row1.getCell(j);
					String str7= String.valueOf(cell);
					preparedStatement.setString(4,str7);
				}
				if(j==1)
				{
					Cell cell1 = row1.getCell(j);
					String str8= String.valueOf(cell1);
					preparedStatement.setString(5,str8);
				}
				if(j==2)
				{
					Cell cell4 = row1.getCell(j);
					String str11= String.valueOf(cell4);
					preparedStatement.setString(6,str11);
				}
				if(j== 3)
				{	
					for(int k =j;k<=j+1;k++)
					{
						Cell cell2 = row1.getCell(j);
					String str9= String.valueOf(cell2);
							str12+=str9;
					}		
					
					preparedStatement.setString(7,str12);
				}
				if(j==(colCount1-2))
				{
					for(int k = j;k<colCount1;k++)
					{
						Cell cell2 = row1.getCell(j);
					String str9= String.valueOf(cell2);
							str14+=str9;
					preparedStatement.setString(8,str14);
					}
				}
		   }
		preparedStatement.addBatch();
        
        if (count % batchSize == 0) {
           preparedStatement.executeBatch();
		   }
		
    	}
		
		//Microbiological Criteria
		
		Row row3= sheet.getRow(39);                              //Analytical Specifications
		int colCount3 =row3.getLastCellNum();
		String str15=" ";
		for(int i=0;i<colCount;i++)
		   {
			Cell cell =row3.getCell(i);
			String str4 = String.valueOf(cell);
			   str15 += str4;
			
		}
		
		
		String str16= "";
		for(int i=41;i<=46;i++)
		{
			
		int count=0;
		preparedStatement.setString(1,f);
		preparedStatement.setString(2,str5);
		Row row1= sheet.getRow(i);
		int colCount1= row1.getLastCellNum();
		
		preparedStatement.setString(3,str15);
		for(int j=0;j<colCount1;j++)
		   {		if(j==0)
		   {
					Cell cell = row1.getCell(j);
					 str16= String.valueOf(cell);
					preparedStatement.setString(4,str16);
				
		   }if(j==1)
		   {
			   Cell cell = row1.getCell(j);
				 str16= String.valueOf(cell);
				preparedStatement.setString(6,str16);

		   }
		   if(j==2)
		   {
			   Cell cell = row1.getCell(j);
				 str16= String.valueOf(cell);
				preparedStatement.setString(8,str16);

		   }
		   if(j==3){
			   Cell cell = row1.getCell(j);
				 str16= String.valueOf(cell);
				preparedStatement.setString(7,str16);

		   }
		   String str17="null";
		   preparedStatement.setString(5, str17);
		   }
		preparedStatement.addBatch();
        
        if (count % batchSize == 0) {
           preparedStatement.executeBatch();
		   }
		
    	}
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
}