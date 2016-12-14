package domain;

public class Chapter {
	private String chapterTitle;
	private String id;
	private String fileName;
	
	
	public Chapter(String chapterTitle, String id) {
		super();
		this.chapterTitle = chapterTitle;
		this.id = id;
		this.fileName = String.format("%s.xml", this.id);
	}
	public String getChapterTitle() {
		return chapterTitle;
	}
	public void setChapterTitle(String chapterTitle) {
		this.chapterTitle = chapterTitle;
	}
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
	
	
	
}
