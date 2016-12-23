package gov.nyc.doitt.nycrules.ws.domain.chapters;



public abstract class ChapterLevelPOJO implements ChapterLevelPOJOInt {
	private String heading;
	private String record;
	
	public ChapterLevelPOJO(){}
	
	
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
