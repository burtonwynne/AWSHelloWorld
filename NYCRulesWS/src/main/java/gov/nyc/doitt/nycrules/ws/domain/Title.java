package gov.nyc.doitt.nycrules.ws.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="titles")
public class Title {
	@Id
	private String id;
	private String titles;
	private List<Chapterlet> chapters = new ArrayList<>();
	private Date last_upated;
	private Date creation_date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitles() {
		return titles;
	}
	public void setTitles(String titles) {
		this.titles = titles;
	}
	public List<Chapterlet> getChapters() {
		return chapters;
	}
	public void setChapters(List<Chapterlet> chapters) {
		this.chapters = chapters;
	}
	public Date getLast_upated() {
		return last_upated;
	}
	public void setLast_upated(Date last_upated) {
		this.last_upated = last_upated;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	
	
}
