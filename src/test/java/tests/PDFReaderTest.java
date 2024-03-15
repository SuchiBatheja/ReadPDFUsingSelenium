package tests;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class PDFReaderTest {

	WebDriver driver;
	String url = "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf";

	@BeforeTest
	public void setup() {

		driver = new ChromeDriver();
		driver.get(url);
	}

	@Test
	public void pdfReaderTest() throws IOException {

		URL pdfUrl = new URL(url);
	InputStream ip = pdfUrl.openStream();
	
	BufferedInputStream bf = new BufferedInputStream(ip);
	
	PDDocument pdfDocument = PDDocument.load(bf);
	
	//Page Count
	int NumberOfPages = pdfDocument.getNumberOfPages();
	
     System.out.println("No of Pages are : "+NumberOfPages);
	//Get the content of the PDF
     
     
     PDFTextStripper pdfStriper = new PDFTextStripper();
     
     String  pdfText= pdfStriper.getText(pdfDocument);
     
     System.out.println("The content of the pdf is : "+pdfText);
     
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
