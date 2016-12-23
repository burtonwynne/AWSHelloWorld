package jaxb.titles;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="document")
public class TitleDocument {
	@XmlTransient
	private String id;
	@XmlTransient
	private String name;
	@XmlTransient
	private String title;
	
	@XmlTransient
	List<TitleDocument> documents = new ArrayList<>();
	
	@XmlAttribute(name="id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@XmlAttribute(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@XmlAttribute(name="title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@XmlElement(name="document")
	public List<TitleDocument> getDocuments() {
		return documents;
	}

	public void setDocuments(List<TitleDocument> documents) {
		this.documents = documents;
	}
	
	
	
}
