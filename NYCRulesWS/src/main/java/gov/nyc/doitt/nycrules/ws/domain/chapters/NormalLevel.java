package gov.nyc.doitt.nycrules.ws.domain.chapters;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.transform.TransformerException;


public class NormalLevel implements ChapterLevelPOJOInt {
	private String content;
	//@XmlTransient
	//protected XSLTTransformUtility xsltTransformer = new XSLTTransformUtility();
	
	public NormalLevel(){
		
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
