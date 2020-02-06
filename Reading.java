package data.java;
import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
public class Reading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			FileInputStream file = new FileInputStream(new File("C:\\Users\\A\\Downloads\\Citricacid.xlsx"));
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(file);
			for(int i =0;i<5;i++)
			{
			XSSFSheet sheet = wb.getSheetAt(i);
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
								case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
								System.out.print(cell.getStringCellValue() + "\t\t\t");  
								break;  
								case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
								System.out.print(cell.getNumericCellValue() + "\t\t\t");  
								break;  
								default:  
							} 
				}
						System.out.println("");
		
		}
			System.out.println("");
			}	
		}catch(Exception e)  
		{  
			e.printStackTrace();  
			}  

	}

}
