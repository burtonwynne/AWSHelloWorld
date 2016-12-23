package utilities;

import java.io.File;
import java.io.StringWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import jaxb.chapterfiles.ChapterDocument;
import jaxb.chapterfiles.ChapterLevel;

public class XSLTTransformUtility {
	protected File stylesheet = new File("resources/ALP.xsl");
	protected StreamSource stylesource;
	protected Transformer transformer;
	
	public XSLTTransformUtility(){
		stylesource = new StreamSource(stylesheet);
		try {
			transformer = TransformerFactory.newInstance().newTransformer(stylesource);
		} catch (TransformerConfigurationException | TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String transformSection(ChapterLevel section) throws TransformerException, JAXBException{
		StringWriter outWriter = new StringWriter();
		StreamResult result = new StreamResult(outWriter);
		//DOMSource domSource = new DOMSource(section);
		JAXBSource jaxbSource = new JAXBSource(JAXBContext.newInstance(section.getClass()), section);
		transformer.transform(jaxbSource, result);
		String output = outWriter.toString()
				.replaceFirst("<\\?xml version=\"1.0\" encoding=\"utf-8\"\\?>", "");//remove xml traces.
		return output;
	}
}
