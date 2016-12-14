package jaxb.chapterfiles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="DOCUMENT")
@XmlAccessorType(XmlAccessType.FIELD)
public class ChapterDocument {
	
	@XmlTransient
	private Reference reference;
	@XmlTransient
	private Level level;
	
	
	
	
	
	@XmlElement(name="REFERENCE")
	public Reference getReference() {
		return reference;
	}

	public void setReference(Reference reference) {
		this.reference = reference;
	}
	
	@XmlElement(name="LEVEL")
	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append(reference.toString());
		builder.append("\n");
		builder.append(level);
		builder.append("\n");
		return builder.toString();
	}
	
	
}


