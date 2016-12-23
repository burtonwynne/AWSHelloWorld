package gov.nyc.doitt.pressreleases.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class PressReleaseController {
	
	
	
	@RequestMapping(value="/document/id/{docId}", method=RequestMethod.GET)
	public ResponseEntity getResource(@PathVariable(name="docId") String docId){
		return null;
	}
	
	
	@RequestMapping(name="/document", method=RequestMethod.GET)
	public Document getNewsFilterResults(@PathVariable(name="category") String category, 
		@PathVariable(name="contentType") String contentType, 
		@PathVariable(name="startDate") String StartDate, 
		@PathVariable(name="language") String language, 
		@PathVariable(name="pageNumber") int pageNumber){
		
			
		return null;
	}
	
	

}
