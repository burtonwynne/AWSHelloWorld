package jaxb.chapterfiles;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PARA")
@XmlAccessorType(XmlAccessType.FIELD)
public class Paragraph {
	@XmlElementRefs({
			@XmlElementRef(name="TAB", type=Tab.class),
			@XmlElementRef(name="LINEBRK", type=LineBreak.class),
			@XmlElementRef(name="CHARFORMAT", type=CharFormat.class),
			@XmlElementRef(name="LINK", type=Link.class)
	})
	@XmlMixed
	protected List<Object> content;
	
	
	public String toString(){
		StringBuilder buffer = new StringBuilder();
		for (Object serializable : content) {
			if(serializable instanceof String){
				buffer.append(serializable);
			}else if(serializable instanceof Tab){
				buffer.append("\t");
			}else if(serializable instanceof LineBreak){
				buffer.append("\n");
			}else if(serializable instanceof CharFormat){
				buffer.append(((CharFormat) serializable).getValue());
			}else if(serializable instanceof Link){
				buffer.append(((Link) serializable).getValue());
			}
		}
		return buffer.toString();
	}
	
	
}










