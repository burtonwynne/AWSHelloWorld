package jaxb.titles;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="content-collection")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContentCollection {
	
	@XmlTransient
	List<Field> fields = new ArrayList<>();
	
	@XmlTransient
	List<IndexSheet> indexSheets = new ArrayList<>();
	
	@XmlTransient
	private List<TitleDocument> documents = new ArrayList<>();
	
	@XmlElement(name="document")
	public List<TitleDocument> getDocuments() {
		return documents;
	}

	public void setDocuments(List<TitleDocument> documents) {
		this.documents = documents;
	}
	@XmlElement(name="field")
	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	
	@XmlElement(name="indexsheet")
	public List<IndexSheet> getIndexSheets() {
		return indexSheets;
	}

	public void setIndexSheets(List<IndexSheet> indexSheets) {
		this.indexSheets = indexSheets;
	}
	
	
}
                     