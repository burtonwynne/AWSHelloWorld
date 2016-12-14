package database;

public enum CollectionNames {
	FILES("files"), DOCUMENTS("documents"), TITLES("titles");
	
	private CollectionNames(String value){
		this.value =  value;
	}

	private String value;
	
	public String value(){
		return value;
	}
}
