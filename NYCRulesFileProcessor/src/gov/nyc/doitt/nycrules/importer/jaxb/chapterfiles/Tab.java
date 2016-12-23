package jaxb.chapterfiles;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="TAB")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tab {
	@XmlTransient
	private String tabCount;

	@XmlAttribute(name="tab-count")
	public String getTabCount() {
		return tabCount;
	}

	public void setTabCount(String tabCount) {
		this.tabCount = tabCount;
	}
	
	
	
}
