package jaxb.chapterfiles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="HEADING")
@XmlAccessorType(XmlAccessType.FIELD)
public class Heading {
	
	@XmlValue
	private String value;

	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}	
	
	public String toString(){
		return value + "\n";
	}
	
	
	
}
