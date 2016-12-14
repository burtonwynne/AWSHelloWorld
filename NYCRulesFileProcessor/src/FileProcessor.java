import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.google.gson.Gson;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;

import database.CollectionNames;
import database.FieldNames;
import domain.Chapter;
import jaxb.chapterfiles.ChapterDocument;
import jaxb.chapterfiles.Level;
import jaxb.titles.Titles;
import jaxb.titles.TitleDocument;

public class FileProcessor {
	public static String hashAlgorithm = "MD5";
	public static MessageDigest digest;
	public static MongoClient mongoClient;
	public static Unmarshaller jaxbDocumentUnmarshaller;
	public static Unmarshaller jaxbMakeFileUnmarshaller;	
	public static Gson gson = new Gson();
	public static DB db;
	public static DBCollection files;
	public static DBCollection documents;
	public static DBCollection titlesCollection;
	public static final String TITLE_DOCUMENT_NAME_IMAGES = "img";
	
	static{
		try {
			digest = MessageDigest.getInstance(hashAlgorithm);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		 mongoClient = new MongoClient();
		 try{
			JAXBContext jaxbContext = JAXBContext.newInstance(ChapterDocument.class);  
		 	jaxbDocumentUnmarshaller = jaxbContext.createUnmarshaller();    
		 	jaxbContext = JAXBContext.newInstance(Titles.class);
		 	jaxbMakeFileUnmarshaller = jaxbContext.createUnmarshaller();
		 }catch(JAXBException jaxbe){
			 jaxbe.printStackTrace(System.out);
		 }
		 
		 db = mongoClient.getDB("directoryStreamTest");
		 files = createFilesCollection(db);
		 documents = createDocumentsCollection(db);
		 titlesCollection = createMakeFileCollection(db);
	}

	public static void main(String[] args) throws NoSuchAlgorithmException, JAXBException {
		Path dir = FileSystems.getDefault().getPath("C:\\NYC Rules XML Files\\XML");
		Path makeFile = FileSystems.getDefault().getPath("C:\\NYC Rules XML Files\\rules.mak.xml");
		
		try {
			processMakeFile(makeFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			   String fileName;
			   String fileHash;
		       for (Path entry : stream) {
		    	   fileName =  entry.getFileName().toString();
		    	   if(fileName.matches(".*\\.xml")){
			          fileHash = getHashAsString(entry);
			          BasicDBObject searchObj = new BasicDBObject();
			          searchObj.put(FieldNames.FILE_NAME.value(), fileName);
			          String oldHash = getOldHashFromDB(fileName, files);
			          if(oldHash != null){
			        	 if(fileHash.equals(oldHash)){
			        		 //System.out.format("file name: %s, matches old hash\n", fileName, fileHash);
			        	 }else{
			        		 updateFile(fileName, fileHash, files);
			        		 ChapterDocument doc = getDocument(entry);
			        		 updateDocument(fileName, doc, documents);
			        	 }
			        	 
			          }else{
			        	  saveFile(fileName, fileHash, files);  

			      		ChapterDocument doc = getDocument(entry);
				          System.out.println("Title: " + doc.getReference().getTitle().getValue());
				          saveDocumentToDB(fileName, doc, documents);
			          }
		    	   }
		       }
		 }catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	

	protected static boolean processMakeFile(Path makeFilePath) throws IOException, JAXBException{
		boolean wasParsed = false;
		String fileName =  makeFilePath.getFileName().toString();
		String fileHash = getHashAsString(makeFilePath);
        String oldHash = getOldHashFromDB(fileName, files);
        if(oldHash != null){
      	 if(fileHash.equals(oldHash)){
      		 //System.out.format("file name: %s, matches old hash\n", fileName, fileHash);
      		 //TODO: Log the fact that the information was the same.
      	 }else{
      		 
      		 //ChapterDocument doc = getDocument(entry);
      		 Titles titles = (Titles) jaxbMakeFileUnmarshaller.unmarshal(makeFilePath.toFile());
      		 updateFile(fileName, fileHash, files);
      		 //updateDocument(fileName, doc, documents);
      	 }
      	 
        }else{
        	  
        	Titles titles = (Titles) jaxbMakeFileUnmarshaller.unmarshal(makeFilePath.toFile());
        	saveMakeFile(fileName, titles, titlesCollection);
        	saveFile(fileName, fileHash, files);
    		//ChapterDocument doc = getDocument(entry);
	        //System.out.println("Title: " + doc.getReference().getTitle().getValue());
	        //saveDocumentToDB(fileName, doc, documents);
        }

		return wasParsed;
	}
	
	protected static String getHashAsString(Path path) throws IOException{
		return getHashAsString(path, hashAlgorithm);
	}
	
	protected static String getOldHashFromDB(String fileName, DBCollection files){
		String oldHash = null;
		 BasicDBObject searchObj = new BasicDBObject();
         searchObj.put(FieldNames.FILE_NAME.value(), fileName);
         DBCursor cursor = files.find(searchObj);
         if(cursor.hasNext()){
        	 DBObject old_file = cursor.next();
        	 oldHash = (String) old_file.get(FieldNames.HASH.value());
         }
         cursor.close();
		return oldHash;
	}
	
	protected static String getHashAsString(Path path, String algorithm) throws IOException{
		byte[] result = digest.digest(Files.readAllBytes(path));
        return new String(result);
	}
	
	protected static boolean saveFile(String fileName, String md5, DBCollection collection){
		boolean saved = false;
		BasicDBObject currentFile = new BasicDBObject();
  	  	currentFile.put(FieldNames.FILE_NAME.value(), fileName);
  	  	currentFile.put(FieldNames.HASH.value(), md5);
  	  	currentFile.put(FieldNames.HASH_ALGORITHM.value(), hashAlgorithm);
  	  	currentFile.put(FieldNames.LAST_UPDATE.value(), new Date());
  	    currentFile.put(FieldNames.CREATION_DATE.value(), new Date());
  	  	WriteResult result = collection.insert(currentFile);
  	  	System.out.format("Adding file name: %s, MD5: %s to mongodb\n", fileName, md5);
  	  	saved = result.isUpdateOfExisting();
		return saved;
	}
	
	protected static DBCollection createFilesCollection(DB db){
		DBCollection collections = db.getCollection(CollectionNames.FILES.value());
		BasicDBObject keys = new BasicDBObject(FieldNames.FILE_NAME.value(), 1)
				//.append("unique", "true")
				;
		collections.createIndex(keys);
		return collections;
	}
	
	protected static DBCollection createDocumentsCollection(DB db){
		DBCollection collection = db.getCollection(CollectionNames.DOCUMENTS.value());
		//BasicDBObject keys = new BasicDBObject(NYCRulesDBFieldNames.FILE_NAME.value(), 1)
				//.append("unique", "true")
				;
		//collection.createIndex(keys);
		return collection;
	}
	
	private static DBCollection createMakeFileCollection(DB db2) {
		DBCollection collection = db.getCollection(CollectionNames.TITLES.value());
		return collection;
	}
	
	protected static boolean updateFile(String fileName, String hash, DBCollection collection){
		boolean fileUpdated = false;
		BasicDBObject updateObj = new BasicDBObject();
		BasicDBObject queryObj = new BasicDBObject();
		updateObj.append(FieldNames.FILE_NAME.value(), fileName)
		.append(FieldNames.HASH_ALGORITHM.value(), hashAlgorithm)
			.append(FieldNames.HASH.value(), hash)
			.append(FieldNames.LAST_UPDATE.value(), new Date());
		WriteResult result = collection.update(queryObj, updateObj);
		fileUpdated = result.isUpdateOfExisting();
		if(fileUpdated){
			System.out.format("Updated file name: %s, MD5: %s to mongodb\n", fileName, hash);
		}else{
			System.out.format("Couldn't Updated file name: %s, MD5: %s to mongodb\n", fileName, hash);
		}
		return fileUpdated;
		
	}
	
	protected static boolean updateDocument(String fileName, ChapterDocument doc, DBCollection collection){
		boolean documentUpdated = false;
		BasicDBObject queryObj = new BasicDBObject();
		
		BasicDBObject updateObj = createChapterDocumentDBObject(fileName, doc);
		WriteResult result = collection.update(queryObj, updateObj);
		documentUpdated = result.isUpdateOfExisting();
		if(documentUpdated){
			System.out.format("Updated document name: %s in mongodb\n", fileName);
		}else{
			System.out.format("Couldn't update document: %s in mongodb\n", fileName);
		}
		return documentUpdated;
		
	}
	
	protected static ChapterDocument getDocument(Path docPath) throws JAXBException{
		return (ChapterDocument) jaxbDocumentUnmarshaller.unmarshal(docPath.toFile());
	}
	
	protected static Titles getMakeFile(Path makeFilePath) throws JAXBException{
		return (Titles) jaxbMakeFileUnmarshaller.unmarshal(makeFilePath.toFile());
	}
	
	protected static boolean saveDocumentToDB(String fileName, ChapterDocument doc, DBCollection collection){
		System.out.println("saveDocumentToDB called.");
		boolean saved = false;
        
		BasicDBObject documentDBObject = createChapterDocumentDBObject(fileName, doc);
		documentDBObject.append(FieldNames.CREATION_DATE.value(), new Date());
				
		WriteResult result = collection.insert(documentDBObject);
		saved = result.wasAcknowledged();
		if(saved){
  	  		System.out.format("Adding document title: %s file: %s to mongodb\n", documentDBObject.getString(FieldNames.TITLE.value()), fileName);
		}else{
			System.out.println("\tFailed: " + result.toString());
		}
  	  	
  	  	return saved;
	}
	
	private static boolean saveMakeFile(String fileName, Titles makeFile, DBCollection collection) {
		System.out.println("saveMakeFile");
		boolean saved = false;
		collection.remove(new BasicDBObject());//remove all of the old data.
		
		List<TitleDocument> documents = makeFile.getCollection().getDocuments();
		for(TitleDocument document: documents){
			if(!TITLE_DOCUMENT_NAME_IMAGES.equals(document.getName())){
				BasicDBObject documentObj = createMakeFileDBObject(fileName, document);
				documentObj.put(FieldNames.CREATION_DATE.value(), new Date());
				WriteResult result = collection.insert(documentObj);
				System.out.format("Successfully wrote chapter tile(\"%s\"): %b\n", document.getTitle(), result.wasAcknowledged());
			}else{
				
			}
		}
		return saved;
	}
	
	protected static BasicDBObject createChapterDocumentDBObject(String fileName, ChapterDocument doc){
		BasicDBObject documentDBObject = new BasicDBObject();
		BasicDBObject json = createBasicDBObjectFromDocument(doc);
        BasicDBList sections = createDBBasicDBObjectForSections(doc);
        String title = doc.getReference().getTitle().getValue();
        String chapterTitle = doc.getLevel().getRecords().get(0).getHeading().getValue();
		documentDBObject.put(FieldNames.FILE_NAME.value(), fileName);
		documentDBObject.put(FieldNames.TITLE.value(), title);
		documentDBObject.put(FieldNames.CHAPTER_NAME.value(), chapterTitle);
		documentDBObject.put(FieldNames.DOCUMENT.value(), json);
		if(sections != null){
			documentDBObject.put(FieldNames.SECTIONS.value(), sections);
		}
		documentDBObject.put(FieldNames.LAST_UPDATE.value(), new Date());
		return documentDBObject;
	}
	
	protected static BasicDBObject createMakeFileDBObject(String filename, TitleDocument makeFileDocument){
		BasicDBObject makeFileObj = new BasicDBObject();
		BasicDBList chapters = getChapters(makeFileDocument);
		//makeFileObj.put(NYCRulesDBFieldNames.CREATION_DATE.value(), new Date());
		makeFileObj.put(CollectionNames.TITLES.value(), makeFileDocument.getTitle());
		makeFileObj.put(FieldNames.CHAPTERS.value(), chapters);
		makeFileObj.put(FieldNames.LAST_UPDATE.value(), new Date());
		return makeFileObj;
	}
	
	protected static BasicDBList getChapters(TitleDocument document){
		List<Chapter> chapterList = new ArrayList<>();
		for(TitleDocument chapter : document.getDocuments()){
			chapterList.add(new Chapter(chapter.getTitle(), chapter.getId()));
		}
		return (BasicDBList) JSON.parse(gson.toJson(chapterList));
	}
	
	protected static BasicDBObject createBasicDBObjectFromDocument(ChapterDocument document){
		return (BasicDBObject) JSON.parse(gson.toJson(document));
	}
	
	protected static BasicDBList createDBBasicDBObjectForSections(ChapterDocument document){
		BasicDBList sections = null;
		Level chapter = document.getLevel();
		if(chapter != null && !chapter.getLevels().isEmpty()){
			Level subchapter = chapter.getLevels().get(0);
			if(subchapter != null && !subchapter.getLevels().isEmpty()){
				Level part = subchapter.getLevels().get(0);
				if(part != null && !part.getLevels().isEmpty()){
					List<Level> levels = part.getLevels();
					sections = (BasicDBList) JSON.parse(gson.toJson(levels));
				}
			}
		}
		return sections;
	}
}


