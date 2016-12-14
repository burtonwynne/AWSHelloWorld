package jaxb.chapterfiles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="REFERENCE")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reference {
	
	@XmlTransient
	private Title title;
	
	@XmlElement(name="TITLE")
	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}
	
	public String toString(){
		return title.toString();
	}
}
