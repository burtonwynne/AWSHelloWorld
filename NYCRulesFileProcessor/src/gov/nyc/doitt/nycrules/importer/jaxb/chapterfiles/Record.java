package jaxb.chapterfiles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="RECORD")
@XmlAccessorType(XmlAccessType.FIELD)
public class Record extends Element{
	@XmlTransient
	private Heading heading;
	
	@XmlTransient
	private Paragraph paragraph;
	
	@XmlTransient
	private String _id;
	
	
	@XmlAttribute(name="id")
	public String getId() {
		return _id;
	}


	public void setId(String id) {
		this._id = id;
	}


	@XmlElement(name="HEADING")
	public Heading getHeading() {
		return heading;
	}
	
	
	public void setHeading(Heading heading) {
		this.heading = heading;
	}

	@XmlElement(name="PARA")
	public Paragraph getParagraph() {
		return paragraph;
	}

	public void setParagraph(Paragraph paragraph) {
		this.paragraph = paragraph;
	}
	
	public String toString(){
		StringBuilder buffer = new StringBuilder();
		//buffer.append(String.format("record(id=%s)\n", id));
		
		if(heading != null){
			buffer.append(heading);
			buffer.append("\n");
		}
		if(paragraph != null){
			buffer.append(paragraph);
			buffer.append("\n");
		}
		
		return buffer.toString();
		
	}
}
