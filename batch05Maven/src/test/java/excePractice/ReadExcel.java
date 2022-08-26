package excePractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import reusables.Constants;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		//give the path of the excel file to read
		FileInputStream fis=new FileInputStream(Constants.EXCEL_PATH);
		//create object for workbook
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		//get excel sheet
		XSSFSheet st=wb.getSheet("TestCases");
		//read data from excel sheet row and column wise
		String data=st.getRow(1).getCell(2).toString();
		System.out.println("excel data is:"+data);
		String mobileNo=st.getRow(1).getCell(3).toString();
		System.out.println("Mobile NO is:"+mobileNo);
		String errorMessage=st.getRow(1).getCell(4).toString();
		System.out.println("error messaeg is:"+errorMessage);
		//close work book
		wb.close();
		fis.close();
		System.out.println("Done");
	}

}
