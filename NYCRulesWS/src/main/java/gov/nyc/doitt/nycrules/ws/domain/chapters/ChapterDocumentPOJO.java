package gov.nyc.doitt.nycrules.ws.domain.chapters;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.util.JSON;

@Document(collection="chapters")
public class ChapterDocumentPOJO extends ChapterLevelPOJO{
	private String title;
	@Id
	private String id;
	@Field(value="file_name")
	private String fileName;
	@XmlTransient
	//private Gson gson = new Gson();
	
	private List<SubChapter> subChapters = new ArrayList<>();
	
	public ChapterDocumentPOJO(){}
	
	
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Field(value="subchapters")
	public List<SubChapter> getSubChapters() {
		return subChapters;
	}
	
	public void setSubChapters(List<SubChapter> subChapters) {
		this.subChapters = subChapters;
	}
	
	
}
