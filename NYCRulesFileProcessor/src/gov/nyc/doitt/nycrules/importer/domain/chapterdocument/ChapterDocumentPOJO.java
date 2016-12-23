package domain.chapterDocument;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

import com.google.gson.Gson;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.util.JSON;

import jaxb.chapterfiles.ChapterDocument;
import jaxb.chapterfiles.ChapterLevel;
import jaxb.chapterfiles.Record;

public class ChapterDocumentPOJO extends ChapterLevelPOJO{
	private String title;
	private String id;
	private String fileName;
	@XmlTransient
	//private Gson gson = new Gson();
	
	private List<SubChapter> subChapters = new ArrayList<>();
	
	public ChapterDocumentPOJO(){}
	
	public ChapterDocumentPOJO(ChapterDocument document){
		super(document.getLevel());
		this.title = document.getReference().getTitle().getValue();
		this.id = document.getReference().getTitle().getId();
		this.fileName = String.format("%s.xml", this.id);
		//create SubCpaters
		ChapterLevel chapter = document.getLevel();
		for(ChapterLevel subChap: chapter.getLevels()){
			subChapters.add(new SubChapter(subChap));
		}
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<SubChapter> getSubChapters() {
		return subChapters;
	}
	
	public void setSubChapters(List<SubChapter> subChapters) {
		this.subChapters = subChapters;
	}
	
	public BasicDBObject getJSON(){
		Gson gson = new Gson();
		try{
			return (BasicDBObject) JSON.parse(gson.toJson(this));
		}catch(Exception ex){
			System.out.format("<!-- Error File: %s --!>\n", fileName);
			ex.printStackTrace();
			return new BasicDBObject();
		}
		
	}
	
	public BasicDBList getSubChaptersJSON(){
		Gson gson = new Gson();
		return (BasicDBList) JSON.parse(gson.toJson(subChapters));
	}
}
