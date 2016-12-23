package gov.nyc.doitt.nycrules.ws.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//@Document(collection="chapters")
public class Chapter {
	
	@Id
	private String id;
	@Field(value="file_name")
	private String fileName;
	@Field(value="chapter_name")
	private String chapterName;
	@Field(value="last_update")
	private Date lastUpdate;
	@Field(value="creation_date")
	private Date creationDate;
	
	//@Field(value="document")
	//private Document1 document;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	/*
	public Document1 getDocument() {
		return document;
	}
	public void setDocument(Document1 document) {
		this.document = document;
	}
	*/
	
	
	
}
