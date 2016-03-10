package study.spring.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.spring.domain.Contact;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFBuilder extends AbstractPDFView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
				
		// get data model which is passed by spring container
			List<Contact> contactList = (List<Contact>) model.get("contactList");
				
			document.add(new Paragraph("Contact List"));
			PdfPTable table = new PdfPTable(6);
			table.setWidthPercentage(100.0f);
			table.setWidths(new float[]{0.10f,2.0f,2.0f,2.0f,2.0f,4.0f});
				
			//define font for table header row
			Font font = FontFactory.getFont(FontFactory.HELVETICA);
			font.setColor(BaseColor.WHITE);
				
			//define table header cell
			PdfPCell cell = new PdfPCell();
			cell.setBackgroundColor(BaseColor.BLUE);
			cell.setPadding(5);
				
			//write table header
			cell.setPhrase(new Phrase("ID",font));
			table.addCell(cell);
				
			cell.setPhrase(new Phrase("First Name",font));
			table.addCell(cell);
				
			cell.setPhrase(new Phrase("Last Name",font));
			table.addCell(cell);
				
			cell.setPhrase(new Phrase("Gender",font));
			table.addCell(cell);
				
			cell.setPhrase(new Phrase("Mobile",font));
			table.addCell(cell);
				
			cell.setPhrase(new Phrase("Email", font));
			table.addCell(cell);
				
			//write table row data
			for(Contact contact:contactList){
				table.addCell(new Phrase(""+contact.getContactId()));
				table.addCell(new Phrase(contact.getFirstName()));
				table.addCell(new Phrase(contact.getLastName()));
				table.addCell(new Phrase(contact.getGender()));
				table.addCell(new Phrase(contact.getMobile()));
				table.addCell(new Phrase(contact.getEmail()));
			}
			document.add(table);

	}

}
