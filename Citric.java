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

public class Citric {

	public static void main(String[] args) throws IOException {
		String str2="";
		// TODO Auto-generated method stub
		Connection connection = null;
		 PreparedStatement preparedStatement = null;
		 
		 try
		 {
		 Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Bhavya","postgres", "postgres");
		String s="C:\\Users\\A\\Desktop\\React\\Input\\Acid, Citric, Granular, Non-GMO, Anhydrous Subs 1020791.xlsx";
		File file = new File(s); 
		 preparedStatement = connection.prepareStatement("insert into ird_internship4 values(?,?,?,?,?,?,?,?)");
	  //creating a new file instance  
		FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
		//creating Workbook instance that refers to .xlsx file  
		XSSFWorkbook wb = new XSSFWorkbook(fis);   
		XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
	/*	Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
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
		}  */
		String f=s.substring(31);		//filename
		Row row= sheet.getRow(1);  //Ingredient Name
		int colCount= row.getLastCellNum();
		String str5=" ";
		for(int i=1;i<colCount;i++)
		   {
			Cell cell =row.getCell(i);
			String str4 = String.valueOf(cell);
			   str5 += str4;
			
		}
		Row row1= sheet.getRow(15);                              //fs
		int colCount1 =row1.getLastCellNum();
		String str6=" ";
		for(int i=0;i<colCount1;i++)
		   {
			Cell cell =row1.getCell(i);
			String str4 = String.valueOf(cell);
			   str6 += str4;
			
		}
		String str12=" ";
		int batchSize = 20;
		for(int i=17;i<=21;i++)
		{
			
		int count=0;
		preparedStatement.setString(1,f);
		preparedStatement.setString(2,str5);
		Row row2= sheet.getRow(i);
		int colCount2= row2.getLastCellNum();
		
		preparedStatement.setString(3,str6);
		for(int j=0;j<colCount2;j++)
		   {		
			if(j==0)
			{
				Cell cell = row2.getCell(j);
				String str7= String.valueOf(cell);
				preparedStatement.setString(4,str7);
			}
			if(j==1||j==2)
			{
				for(int k=j;k<=2;k++)
				{
				Cell cell1 = row2.getCell(k);
				String str8= String.valueOf(cell1);
						str12+=str8;
				}		
				preparedStatement.setString(5,str12);
			}
			if(j==(colCount2-3))
			{
				Cell cell2 = row2.getCell(j);
			String str9= String.valueOf(cell2);
			preparedStatement.setString(6,str9);
			}
			if(j==(colCount2)-2)
			{
			Cell cell3 = row2.getCell(j);
			String str10= String.valueOf(cell3);
			preparedStatement.setString(7,str10);
			}
			if((j==(colCount2)-1))
			{
			Cell cell4 = row2.getCell(j);
			String str11= String.valueOf(cell4);
			preparedStatement.setString(8,str11);
			}
			
			}
		preparedStatement.addBatch();
         
         if (count % batchSize == 0) {
            preparedStatement.executeBatch();
		   }
		
		}
		
		for(int i =31;i<32;i++)
		{
			int count=0;
			preparedStatement.setString(1,f);
			preparedStatement.setString(2,str5);
			Row row5= sheet.getRow(i);
			int colCount2= row5.getLastCellNum();
			
			preparedStatement.setString(3,str6);
			for(int j=0;j<colCount2;j++)
			{
				if(j==0)
				{
					Cell cell = row5.getCell(j);
					String str7= String.valueOf(cell);
					preparedStatement.setString(4,str7);
					
				}
				if(j==1)
				{
					Cell cell = row5.getCell(j);
					String str7= String.valueOf(cell);
					preparedStatement.setString(5,str7);
				}
				if(j==2)
				{
					Cell cell = row5.getCell(j);
					String str7= String.valueOf(cell);
					preparedStatement.setString(6,str7);
				}
				if(j==3)
				{
					Cell cell = row5.getCell(j);
					String str7= String.valueOf(cell);
					preparedStatement.setString(7,str7);
				}
				if(j==4)
				{
					Cell cell = row5.getCell(j);
					String str7= String.valueOf(cell);
					preparedStatement.setString(8,str7);
				}
			}
			preparedStatement.addBatch();
	         
	         if (count % batchSize == 0) {
	            preparedStatement.executeBatch();
			   }
			
		}
		
	 String str15 = " ";
		Row row3= sheet.getRow(32);						//as
		for(int i=0;i<colCount1;i++)
		   {
			Cell cell =row3.getCell(i);
			String str4 = String.valueOf(cell);
			   str15 += str4;	
		   }
		for(int i=34;i<=41;i++)
		{
			
		int count=0;
		preparedStatement.setString(1,f);
		preparedStatement.setString(2,str5);
		Row row2= sheet.getRow(i);
		int colCount3= row2.getLastCellNum();
		
		preparedStatement.setString(3,str15);
		for(int j=0;j<colCount3;j++)
		   {		
				if(j==0)
				{
					Cell cell = row2.getCell(j);
					String str7= String.valueOf(cell);
					preparedStatement.setString(4,str7);
				}
				if(j==1)
				{
					Cell cell1 = row2.getCell(j);
					String str8= String.valueOf(cell1);
					preparedStatement.setString(5,str8);
				}
				if(j==2)
				{
					Cell cell4 = row2.getCell(j);
					String str11= String.valueOf(cell4);
					preparedStatement.setString(6,str11);
				}
				if(j== 3)
				{	
					
						Cell cell2 = row2.getCell(j);
					String str9= String.valueOf(cell2);
					
					preparedStatement.setString(7,str9);
				}
				if(j==4)
				{
		
						Cell cell2 = row2.getCell(j);
					String str9= String.valueOf(cell2);
					preparedStatement.setString(8,str9);
				}
				
		   }
		preparedStatement.addBatch();
        
        if (count % batchSize == 0) {
           preparedStatement.executeBatch();
		   }
		
    	}
		for(int i=51;i<=52;i++)
		{
			int count=0;
			preparedStatement.setString(1,f);
			preparedStatement.setString(2,str5);	
			preparedStatement.setString(3,str15);
			Row row6= sheet.getRow(52);
			int colCount6 = row6.getLastCellNum();
			for(int j=0;j<colCount6;j++)
			{
				if(j==0)
				{
					Cell cell = row6.getCell(j);
					String str7= String.valueOf(cell);
					preparedStatement.setString(4,str7);
				}
				if(j==1)
				{
					Cell cell1 = row6.getCell(j);
					String str8= String.valueOf(cell1);
					preparedStatement.setString(5,str8);
				}
				if(j==2||j==3)
				{
					for(int k=j;k<=3;k++)
					{
					Cell cell1 = row6.getCell(k);
					String str8= String.valueOf(cell1);
							str12+=str8;
					}	
					preparedStatement.setString(6,str12);
					
				}
				if(j==4)
				{
					Cell cell2 = row6.getCell(j);
					String str9= String.valueOf(cell2);
					
					preparedStatement.setString(7,str9);
			}
				if(j==5)
				{
					Cell cell2 = row6.getCell(j);
					String str9= String.valueOf(cell2);
					preparedStatement.setString(8,str9);
				}
				preparedStatement.addBatch();
		        
		        if (count % batchSize == 0) {
		           preparedStatement.executeBatch();
				   }
				
		    	}
		}
		
		//Microbiological Criteria
		
		Row row4= sheet.getRow(53);                              
		int colCount4 =row4.getLastCellNum();
		String str17=" ";
		for(int i1=0;i1<colCount4;i1++)
		   {
			Cell cell =row4.getCell(i1);
			String str4 = String.valueOf(cell);
			   str17 += str4;
			
		}
		
	
		String str16= "";
		String str20=" "; String str18="";
		for(int i2=55;i2<=60;i2++)
		{
			
		int count1=0;
		preparedStatement.setString(1,f);
		preparedStatement.setString(2,str5);
		Row row5= sheet.getRow(i2);
		int colCount5= row5.getLastCellNum();
		
		preparedStatement.setString(3,str17);
		for(int j=0;j<colCount5;j++)
		   {		if(j==0)
		   			{
					Cell cell = row5.getCell(j);
					 str16= String.valueOf(cell);
					preparedStatement.setString(4,str16);
				
		   			}
		   if(j==1)
		   		{
			  
			   Cell cell = row5.getCell(j);
				String str23= String.valueOf(cell);
			   preparedStatement.setString(6,str23);
		   		}
		   
		   	if(j==4||j==5)
		   		{
			   for(int k=j;k<=5;k++ )
			   {
			   Cell cell = row5.getCell(j);
				String str8= String.valueOf(cell);
				 str20+=str8;
				preparedStatement.setString(7,str20);

			   }
		   if(j==2||j==3)
		   			{
			   for(int k=j;k<=3;k++)
			   {
			   Cell cell = row5.getCell(j);
				 str16= String.valueOf(cell);
				 str18+=str16;
			   }
				preparedStatement.setString(8,str18);

		   			}
		   String str19="null";
		   preparedStatement.setString(5, str19);
		   }
		preparedStatement.addBatch();
        
        if (count1 % batchSize == 0) {
           preparedStatement.executeBatch();
		   }
		
    	}
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
