package database;

public enum FieldNames {
	FILE_NAME("file_name"), HASH("hash"), HASH_ALGORITHM("hashAlgorithm"), LAST_UPDATE("last_update"), 
		CREATION_DATE("creation_date"), TITLE("title"), CHAPTER_NAME("chapter_name"), DOCUMENT("document"),
		SECTIONS("sections"), CHAPTERS("chapters"), ; 
	
	private String value;
	
	private FieldNames(String value) {
		this.value = value;
	}
	
	public String value(){
		return value;
	}
}
