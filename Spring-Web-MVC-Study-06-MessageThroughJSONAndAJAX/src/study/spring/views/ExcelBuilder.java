package study.spring.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import study.spring.domain.Contact;

@SuppressWarnings("deprecation")
public class ExcelBuilder extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//get data model which pass by Spring container
		List<Contact> contactList = (List<Contact>) model.get("contactList");
		
		//create new sheet in the workbook
		HSSFSheet sheet = workbook.createSheet("Contact List");
		sheet.setDefaultColumnWidth(30);
		
		//Add Style for Header Row
		CellStyle style = workbook.createCellStyle();
		style.setFillBackgroundColor(HSSFColor.DARK_BLUE.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		//Create Font for the Header Row		
		HSSFFont font = workbook.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 16);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		
		
		// Add Font to the header Style
		style.setFont(font);
		
		//Create header row
		HSSFRow header = sheet.createRow(0);
		
		header.createCell(0).setCellValue("Contact Id");
		header.getCell(0).setCellStyle(style);
		
		header.createCell(1).setCellValue("First Name");
		header.getCell(1).setCellStyle(style);
		
		header.createCell(2).setCellValue("Last Name");
		header.getCell(2).setCellStyle(style);
		
		header.createCell(3).setCellValue("Gender");
		header.getCell(3).setCellStyle(style);
		
		header.createCell(4).setCellValue("Mobile");
		header.getCell(4).setCellStyle(style);
		
		header.createCell(4).setCellValue("Email");
		header.getCell(4).setCellStyle(style);
		
		// create data row
		int rowCount=1;
		for(Contact c:contactList){
			HSSFRow dataRow = sheet.createRow(rowCount);
			dataRow.createCell(0).setCellValue(c.getContactId());
			dataRow.createCell(1).setCellValue(c.getFirstName());
			dataRow.createCell(2).setCellValue(c.getLastName());
			dataRow.createCell(3).setCellValue(c.getGender());
			dataRow.createCell(4).setCellValue(c.getMobile());
			dataRow.createCell(5).setCellValue(c.getEmail());
			rowCount++;
		}

	}

}
