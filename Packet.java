package data.java;
import java.io.*;
import java.sql.*;
import java.lang.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
public class Packet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Packet pack = new Packet();
		pack.export();

	}


public void export() {
    

    String excelFilePath = "Reviews-export.xlsx";

    
    
    		try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Bhavya","postgres", "postgres"))
    		{
        String sql = "SELECT * FROM employee2";

        Statement statement = connection.createStatement();

        ResultSet result = statement.executeQuery(sql);

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Reviews");

        writeHeaderLine(sheet);

        writeDataLines(result, workbook, sheet);

        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
        workbook.close();

        statement.close();

    } catch (SQLException e) {
        System.out.println("Datababse error:");
        e.printStackTrace();
    } catch (IOException e) {
        System.out.println("File IO error:");
        e.printStackTrace();
    }
}
private void writeHeaderLine(XSSFSheet sheet) {
	 
    Row headerRow = sheet.createRow(0);

    Cell headerCell = headerRow.createCell(0);
    headerCell.setCellValue("Identity");

    headerCell = headerRow.createCell(1);
    headerCell.setCellValue("Student Name");

    headerCell = headerRow.createCell(2);
    headerCell.setCellValue("DOB");

    headerCell = headerRow.createCell(3);
    headerCell.setCellValue("Emailid");
} private void writeDataLines(ResultSet result, XSSFWorkbook workbook,
        XSSFSheet sheet) throws SQLException {
    int rowCount = 1;

    while (result.next()) {
        int identity = result.getInt("uid");
        String studentName = result.getString("name");
        String dateofbirth = result.getString("dob");
        String email_id = result.getString("email");

        Row row = sheet.createRow(rowCount++);

        int columnCount = 0;
        Cell cell = row.createCell(columnCount++);
        cell.setCellValue(identity);

        cell = row.createCell(columnCount++);
        cell.setCellValue(studentName);

        cell = row.createCell(columnCount++);

        /*CellStyle cellStyle = workbook.createCellStyle();
        CreationHelper creationHelper = workbook.getCreationHelper();
        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd"));
        cell.setCellStyle(cellStyle);*/

        cell.setCellValue(dateofbirth);

        cell = row.createCell(columnCount++);
        cell.setCellValue(email_id);


    }
}
}