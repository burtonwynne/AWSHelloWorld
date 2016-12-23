package jaxb.titles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="makefile")
@XmlAccessorType(XmlAccessType.FIELD)
public class Titles {
	
	//@XmlTransient
	@XmlElement(name="content-collection")
	private ContentCollection collection;
	
	
	
	public ContentCollection getCollection() {
		return collection;
	}

	public void setCollection(ContentCollection collection) {
		this.collection = collection;
	}
	
	

}
