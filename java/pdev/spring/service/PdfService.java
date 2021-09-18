package pdev.spring.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import pdev.spring.entity.Credit;
import com.itextpdf.text.DocumentException;

@Service
public class PdfService {

    private static final String PDF_RESOURCES = "/templates/";
    private SpringTemplateEngine templateEngine;
    Credit credit;

    @Autowired
    public PdfService( CreditService creditService, SpringTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public File generatePdf(Optional<Credit> credit) throws IOException, DocumentException {
        Context context = getContext(credit);
        String html = loadAndFillTemplate(context);
        return renderPdf(html);
    }

    private File renderPdf(String html) throws IOException, DocumentException {
        File file = File.createTempFile("credit", ".pdf");
        OutputStream outputStream = new FileOutputStream(file);
        ITextRenderer renderer = new ITextRenderer(20f * 4f / 3f, 20);
        renderer.setDocumentFromString(html, new ClassPathResource(PDF_RESOURCES).getURL().toExternalForm());
        renderer.layout();
        try {
			renderer.createPDF(outputStream);
		} catch (com.lowagie.text.DocumentException e) {
			e.printStackTrace();
		}
        outputStream.close();
        file.deleteOnExit();
        return file;
    }
    private Context getContext(Optional<Credit> credit) {
    	
        Context context = new Context();
		context.setVariable("credit", credit.get());
        return context;
    }
    private String loadAndFillTemplate(Context context) {
        return templateEngine.process("credit", context);
    }
}