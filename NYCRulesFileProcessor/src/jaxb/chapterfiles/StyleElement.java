package jaxb.chapterfiles;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public abstract class StyleElement {
	@XmlTransient
	protected String styleName;
	
	@XmlTransient
	protected String styleNameEscaped;
	
	@XmlTransient
	protected String styleId;
	
	@XmlAttribute(name="style-Name")
	public String getStyleName() {
		return styleName;
	}
	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}
	@XmlAttribute(name="style-name-escaped")
	public String getStyleNameEscaped() {
		return styleNameEscaped;
	}
	public void setStyleNameEscaped(String styleNameEscaped) {
		this.styleNameEscaped = styleNameEscaped;
	}
	@XmlAttribute(name="style=id")
	public String getStyleId() {
		return styleId;
	}
	public void setStyleId(String styleId) {
		this.styleId = styleId;
	}
}
