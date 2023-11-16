package Controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.newcrud.entity.Student;

import Entity.Book;
import Repository.BookRepo;

@RestController

public class BookController {
	@Autowired
	private BookRepo repo;
	@GetMapping("/getBooks")
	public ResponseEntity<Object> getAllBooks() {
		try {
			List<Book> booklist =repo.findAll();
			repo.findAll();
			if(booklist.isEmpty()){
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e ) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getBook/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable int id){
		Optional<Entity.Book> bookData = repo.findById(id);
		if(bookData.isPresent()) {
			return new ResponseEntity<Book>(HttpStatus.OK);
			
		}
		return new ResponseEntity (HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/addBook")
	public ResponseEntity<Book> addBook(@RequestBody Book book){
		Book bookObj = repo.save(book);
		if(bookObj!=null) {
		return new ResponseEntity<Book>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	@PutMapping("/getStudents/{id}")
	public ResponseEntity updateStudent(@PathVariable int id,@RequestBody Book newBookData){
		Optional <Book> oldBook =  repo.findById(id);
		if(oldBook.isPresent()) {
			Book updateBook = oldBook.get();
			updateBook.setBook_Name(newBookData.getBook_Name());
			updateBook.setAuthor(newBookData.getAuthor());
			updateBook.setJournal(newBookData.getJournal());
			updateBook.setPrice(newBookData.getPrice());
			
			Book bookObj = repo.save(updateBook);
			
			return new ResponseEntity<>(bookObj,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
	public ResponseEntity<Book> deleteBook(@PathVariable int id){
		repo.deleteById(id);
		return new ResponseEntity<Book>(HttpStatus.OK);
	}
	
	
	

}
