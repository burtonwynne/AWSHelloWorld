package gov.nyc.doitt.nycrules.ws.domain.chapters;

import java.util.ArrayList;
import java.util.List;


public class SubChapter extends ChapterLevelPOJO{
	
	private List<Part> parts = new ArrayList<>();
	
	
	public SubChapter() {
		super();
	}
	

	public List<Part> getParts() {
		return parts;
	}

	public void setParts(List<Part> parts) {
		this.parts = parts;
	}
	
	
	
}
