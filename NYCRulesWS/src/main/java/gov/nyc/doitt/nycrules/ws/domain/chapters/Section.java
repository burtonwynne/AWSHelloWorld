package gov.nyc.doitt.nycrules.ws.domain.chapters;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.transform.TransformerException;


public class Section extends ChapterLevelPOJO{
	private String content;

	//@XmlTransient
	//protected XSLTTransformUtility xsltTransformer = new XSLTTransformUtility();
	
	public Section(){
		super();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
