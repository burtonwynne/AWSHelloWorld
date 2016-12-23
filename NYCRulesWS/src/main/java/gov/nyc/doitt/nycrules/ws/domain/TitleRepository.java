package gov.nyc.doitt.nycrules.ws.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TitleRepository extends MongoRepository<Title, String> {

}
