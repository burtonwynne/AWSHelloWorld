package gov.nyc.doitt.nycrules.ws.domain.chapters;

import java.util.ArrayList;
import java.util.List;

public class Part extends ChapterLevelPOJO{
	private List<Section> sections = new ArrayList<>();
	
	public Part(){
		super();
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	
	
}
