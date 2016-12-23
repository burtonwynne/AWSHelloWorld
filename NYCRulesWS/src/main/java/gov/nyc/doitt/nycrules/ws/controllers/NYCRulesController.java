package gov.nyc.doitt.nycrules.ws.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gov.nyc.doitt.nycrules.ws.domain.Chapter;
import gov.nyc.doitt.nycrules.ws.domain.ChapterRepository;
import gov.nyc.doitt.nycrules.ws.domain.Title;
import gov.nyc.doitt.nycrules.ws.domain.TitleRepository;
import gov.nyc.doitt.nycrules.ws.domain.chapters.ChapterDocumentPOJO;

@RestController
public class NYCRulesController {

	@Autowired
	protected TitleRepository titleRepository;
	
	@Autowired 
	protected ChapterRepository chapterRepository;
	
	@RequestMapping(value="titles", method=RequestMethod.GET)
	public Title[] getTitles(){
		List<Title> titles = titleRepository.findAll();
		return titles.toArray(new Title[titles.size()]);
	}
	
	
	
	@RequestMapping(value="chapter/{chapterId}", method=RequestMethod.GET)
	public ChapterDocumentPOJO getDocument(@PathVariable(name="chapterId") String chapterId){
		List<ChapterDocumentPOJO> chapters 
			= chapterRepository.findByFileNameLight(String.format("%s.xml", chapterId));
		if(chapters != null && !chapters.isEmpty()){
			return chapters.get(0);
		}else{
			return null;
		}
	}
	
		
}
