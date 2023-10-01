package organization;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadDataFromPdf {

	public static void main(String[] args) throws IOException {
		File file=new File("./src/test/resources/11-Nov-2022 to 10-Dec-2022 Mobile Bill.pdf");
		PDDocument doc= PDDocument.load(file);
		//pageCount
		int pages = doc.getNumberOfPages();
		System.out.println(pages);
		
		//ReadContent
		PDFTextStripper pdfData=new PDFTextStripper();
		String data = pdfData.getText(doc);
		System.out.println(data);
		
	}

}
