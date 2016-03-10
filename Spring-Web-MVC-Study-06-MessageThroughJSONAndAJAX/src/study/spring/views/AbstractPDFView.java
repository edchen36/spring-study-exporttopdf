package study.spring.views;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public abstract class AbstractPDFView extends AbstractView {

	public AbstractPDFView(){
		setContentType("application/pdf");
	}
	
	protected boolean generatesDownloadContent(){
		return true;
	}
	
	/*
	 * Set the size of the page
	 */
	
	protected Document newDocument(){
		return new Document(PageSize.A4);
	}
	
	/*
	 * Create new PDF Writer
	 */
	
	protected PdfWriter newWriter(Document document,OutputStream os)throws DocumentException{
		return PdfWriter.getInstance(document, os);
	}
	
	/*
	 * Get Page Setting Preference
	 */
	protected int getViewerPreference(){
		return PdfWriter.ALLOW_PRINTING | PdfWriter.PageLayoutSinglePage;
		
	}
	
	/*
	 * set PDF Writer with the page setting
	 */
	
	protected void prepareWriter(Map<String,Object> model,PdfWriter pdfwriter,
			HttpServletRequest request)throws DocumentException{
		pdfwriter.setViewerPreferences(getViewerPreference());
		
	}
	
	
	protected void buildPdfMetaData(Map<String,Object> model, Document document, HttpServletRequest request){
		
	}
	
	/**
	 * Used to generate the actual PDF Document and insert data
	 * Implemented by the subclass
	 * */
	protected abstract void buildPdfDocument(Map<String,Object> model,Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//Write into Byte Array First
		ByteArrayOutputStream baos = createTemporaryOutputStream();
		
		//Apply preference and build meta data
		Document document = new Document();
		PdfWriter writer = newWriter(document,baos);
		prepareWriter(model,writer,request);
		buildPdfMetaData(model,document,request);
		
		//Build PDF Document
		document.open();
		buildPdfDocument(model,document,writer,request,response);
		document.close();
		
		// Flush to Http response
		writeToResponse(response,baos);
	}


}
