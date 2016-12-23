package gov.nyc.doitt.nycrules.ws.domain;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import gov.nyc.doitt.nycrules.ws.domain.chapters.ChapterDocumentPOJO;

public interface ChapterRepository extends MongoRepository<ChapterDocumentPOJO, String> {

	List<ChapterDocumentPOJO> findByFileName(String file_name);
	
	
	@Query(value="{'fileName':?0}",  fields="{'document':0, 'heading':0, 'subChapters.parts.sections.content':0}")
	List<ChapterDocumentPOJO> findByFileNameLight(String file_name);

}
