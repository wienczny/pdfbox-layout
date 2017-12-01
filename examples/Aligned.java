import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.pdfbox.pdmodel.font.PDType1Font;

import rst.pdfbox.layout.elements.Document;
import rst.pdfbox.layout.elements.Paragraph;
import rst.pdfbox.layout.elements.render.VerticalLayoutHint;
import rst.pdfbox.layout.text.Alignment;
import rst.pdfbox.layout.util.WordBreakerFactory;

public class Aligned {

    public static void main(String[] args) throws Exception {
	System.setProperty(WordBreakerFactory.WORD_BREAKER_CLASS_PROPERTY, 
		WordBreakerFactory.LEGACY_WORD_BREAKER_CLASS_NAME);
	
	Document document = new Document(40, 60, 40, 60);
	Paragraph paragraph = new Paragraph();
	paragraph.addText("This is some left aligned text", 11,
		PDType1Font.HELVETICA);
	paragraph.setAlignment(Alignment.Left);
	paragraph.setMaxWidth(40);
	document.add(paragraph, VerticalLayoutHint.LEFT);

	paragraph = new Paragraph();
	paragraph.addText("This is some centered text", 11,
		PDType1Font.HELVETICA);
	paragraph.setAlignment(Alignment.Center);
	paragraph.setMaxWidth(40);
	document.add(paragraph, VerticalLayoutHint.CENTER);

	paragraph = new Paragraph();
	paragraph.addText("This is some right aligned text", 11,
		PDType1Font.HELVETICA);
	paragraph.setAlignment(Alignment.Right);
	paragraph.setMaxWidth(40);
	document.add(paragraph, VerticalLayoutHint.RIGHT);

	paragraph = new Paragraph();
	paragraph.addText("Text is right aligned, and paragraph centered", 11,
		PDType1Font.HELVETICA);
	paragraph.setAlignment(Alignment.Right);
	paragraph.setMaxWidth(40);
	document.add(paragraph, VerticalLayoutHint.CENTER);

	final OutputStream outputStream = new FileOutputStream("aligned.pdf");
	document.save(outputStream);

    }
}
