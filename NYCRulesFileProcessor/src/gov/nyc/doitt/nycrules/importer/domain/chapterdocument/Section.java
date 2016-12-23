package domain.chapterDocument;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.transform.TransformerException;

import jaxb.chapterfiles.ChapterLevel;
import utilities.XSLTTransformUtility;

public class Section extends ChapterLevelPOJO{
	private String content;

	//@XmlTransient
	//protected XSLTTransformUtility xsltTransformer = new XSLTTransformUtility();
	
	public Section(){
		super();
	}
	
	public Section(ChapterLevel level){
		super(level);
		try {
			XSLTTransformUtility xsltTransformer = new XSLTTransformUtility();
			content = xsltTransformer.transformSection(level);
		} catch (TransformerException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
