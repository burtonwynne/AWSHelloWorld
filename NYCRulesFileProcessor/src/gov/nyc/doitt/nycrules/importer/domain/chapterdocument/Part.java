package domain.chapterDocument;

import java.util.ArrayList;
import java.util.List;

import jaxb.chapterfiles.ChapterLevel;

public class Part extends ChapterLevelPOJO{
	private List<Section> sections = new ArrayList<>();
	
	public Part(){
		super();
	}
	
	public Part(ChapterLevel level){
		super(level);
		for(ChapterLevel section: level.getLevels()){
			sections.add(new Section(section));
		}
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	
	
}
