package com.galvanize.tmo.paspringstarter;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@RestController
public class LibraryController {

    @GetMapping("/health")
    public void health() {

    }
    
    @PostMapping(
    		value="/api/books",
    		consumes={MediaType.APPLICATION_JSON_VALUE},
    		produces= {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.CREATED)
    public Map createBook(@RequestBody Map<String, Object> bookMap) {
    	bookMap.put("id", 1);
    	return bookMap;
    }
    
    
    @GetMapping(value="/api/books")
    public HashMap<String, Object> getAllBooks() {
    	ArrayList<HashMap<String, Object>> allBooks = new ArrayList<HashMap<String, Object>>();
    	
    	HashMap<String, Object> bookMap1 = new HashMap<String, Object>();
    	bookMap1.put("id", 1);
    	bookMap1.put("author", "Douglas Adams");
    	bookMap1.put("title", "The Hitchhiker's Guide to the Galaxy");
    	bookMap1.put("yearPublished", 1979);
    	
    	HashMap<String, Object> bookMap2 = new HashMap<String, Object>();
    	bookMap2.put("id", 2);
    	bookMap2.put("author", "Philip K. Dick");
    	bookMap2.put("title", "Do Androids Dream of Electric Sheep?");
    	bookMap2.put("yearPublished", 1968);
    	
    	HashMap<String, Object> bookMap3 = new HashMap<String, Object>();
    	bookMap3.put("id", 3);
    	bookMap3.put("author", "William Gibson");
    	bookMap3.put("title", "Neuromancer");
    	bookMap3.put("yearPublished", 1984);
    	
    	allBooks.add(bookMap2);
    	allBooks.add(bookMap3);
    	allBooks.add(bookMap1);
    	
    	HashMap<String, Object> returnValue = new HashMap<String, Object>();
    	returnValue.put("books", allBooks);
    	
    	return returnValue;
    }
    
    @DeleteMapping(value="/api/books")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteAllBooks() {
    	//
    }
    
}
