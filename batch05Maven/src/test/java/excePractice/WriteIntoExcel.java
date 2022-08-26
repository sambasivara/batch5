package excePractice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteIntoExcel {

	public static void main(String[] args) throws IOException {

		// Write a data into file
		FileOutputStream fos = new FileOutputStream(
				"E:\\SeleniumJavaClasses\\Batch5\\workSpace\\batch05Maven\\src\\test\\resources\\TestData\\WriteDataEx.xlsx");
		// create object for workbook
		XSSFWorkbook wb = new XSSFWorkbook();
		// create a sheet
		XSSFSheet st = wb.createSheet("myData");
		// create a row
		XSSFRow rw = st.createRow(1);
		// create a cell or column data
		XSSFCell cl = rw.createCell(1);
		cl.setCellValue("writing data");
		// create a cell or column data
		XSSFCell cl2 = rw.createCell(2);
		cl2.setCellValue("selenium");
		//save or write data into file
		wb.write(fos);
		//close file
		fos.close();
		System.out.println("Done");
		
	}

}
