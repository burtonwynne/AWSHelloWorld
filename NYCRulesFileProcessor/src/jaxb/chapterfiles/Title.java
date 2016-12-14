package jaxb.chapterfiles;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="TITLE")
public class Title {
	@XmlTransient
	private String value;
	
	
	@XmlValue
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
