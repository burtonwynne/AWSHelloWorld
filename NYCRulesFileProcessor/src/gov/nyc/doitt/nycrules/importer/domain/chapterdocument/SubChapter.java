package domain.chapterDocument;

import java.util.ArrayList;
import java.util.List;

import jaxb.chapterfiles.ChapterLevel;
import jaxb.chapterfiles.Record;

public class SubChapter extends ChapterLevelPOJO{
	
	private List<Part> parts = new ArrayList<>();
	
	
	public SubChapter() {
		super();
	}
	
	public SubChapter(ChapterLevel level) {
		super(level);
		
		for(ChapterLevel part: level.getLevels()){
			parts.add(new Part(part));
		}
	}

	public List<Part> getParts() {
		return parts;
	}

	public void setParts(List<Part> parts) {
		this.parts = parts;
	}
	
	
	
}
