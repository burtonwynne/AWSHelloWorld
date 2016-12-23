package jaxb.chapterfiles;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="LEVEL")
@XmlAccessorType(XmlAccessType.FIELD)
public class Level extends Element {
	
	@XmlTransient
	private List<Level> levels = new ArrayList<>();
	
	@XmlTransient
	private List<Record> records = new ArrayList<>();
	
	@XmlTransient
	private String depth;
	
	@XmlTransient
	private String styleName;
	
	
	@XmlAttribute(name="style-name")
	public String getStyleName() {
		return styleName;
	}

	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	@XmlElement(name="LEVEL")
	public List<Level> getLevels() {
		return levels;
	}
	
	
	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}
	

	@XmlElement(name="RECORD")
	public List<Record> getRecords() {
		return records;
	}



	@XmlAttribute(name="level-depth")
	public String getDepth() {
		return depth;
	}



	public void setDepth(String depth) {
		this.depth = depth;
	}



	public String toString(){
		StringBuilder builder = new StringBuilder();
		//builder.append(String.format("level-depth(%s)\n", depth));
		for (Record record : records) {
			builder.append(record);
			builder.append("\n");
		}
		for (Level level : levels) {
			builder.append(level);
			builder.append("\n");
		}
		return builder.toString();
	}
}
