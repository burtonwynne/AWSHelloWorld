package gov.nyc.doitt.nycrules.ws.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "directoryStreamTest";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient();
	}

}
