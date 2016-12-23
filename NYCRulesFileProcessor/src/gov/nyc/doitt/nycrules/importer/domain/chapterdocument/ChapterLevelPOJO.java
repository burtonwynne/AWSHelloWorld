package domain.chapterDocument;

import jaxb.chapterfiles.ChapterLevel;
import jaxb.chapterfiles.Record;

public abstract class ChapterLevelPOJO implements ChapterLevelPOJOInt {
	private String heading;
	private String record;
	
	public ChapterLevelPOJO(){}
	
	public ChapterLevelPOJO(ChapterLevel chapterLevel) {
		if(!chapterLevel.getRecords().isEmpty()){
			Record record = chapterLevel.getRecords().get(0);
			if(record != null){
				if(record.getHeading() != null){
					this.heading = record.getHeading().getValue();
				}
				if( record.getParagraph() != null){
					this.record = record.getParagraph().toString();//I might have to change this.
				}
			}
		}
	}
	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}
}
