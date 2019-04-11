package br.com.pucminas.architeture.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pucminas.architeture.api.models.Author;
import br.com.pucminas.architeture.api.models.Book;
import br.com.pucminas.architeture.api.models.Review;

@RestController("books")
@RequestMapping(path = "/api/v1/books", consumes = "application/json", produces = "application/json")
public class BooksController {

	@GetMapping
	public ResponseEntity<List<Book>> all(@RequestParam(required = false) String name,
			@RequestParam(required = false) int year) {
		return null;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> findById(@PathVariable int id) {
		return null;
	}

	@PostMapping
	public ResponseEntity<Book> newBook(@RequestBody Book book) {
		return new ResponseEntity<Book>(book, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
		return null;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable int id) {
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@GetMapping("/{id}/authors")
	public ResponseEntity<List<Author>> allAuthors(@RequestParam(required = false) String name) {
		return null;
	}

	@GetMapping("/{id}/authors/{idAuthor}")
	public ResponseEntity<Author> findByIdAuthor(@PathVariable int id, @PathVariable int idAuthor) {
		return null;
	}

	@PutMapping("/{id}/authors/{idAuthor}")
	public ResponseEntity<Author> updateAuthor(@PathVariable int id, @PathVariable int idAuthor,
			@RequestBody Author author) {
		return null;
	}

	@DeleteMapping("/{id}/authors/{idAuthor}")
	public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable int id, @PathVariable int idAuthor) {
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@GetMapping("/{id}/reviews")
	public ResponseEntity<List<Review>> allReviews(@RequestParam(required = false) String descripiton) {
		return null;
	}

	@GetMapping("/{id}/reviews/{idReview}")
	public ResponseEntity<Review> findByIdReview(@PathVariable int id, @PathVariable int idReview) {
		return null;
	}

	@PutMapping("/{id}/reviews")
	public ResponseEntity<Review> newReview(@PathVariable int id, @RequestBody Review review) {
		return null;
	}

	@PutMapping("/{id}/reviews/{idReview}")
	public ResponseEntity<Review> updateReview(@PathVariable int id, @PathVariable int idReview,
			@RequestBody Review review) {
		return null;
	}

	@DeleteMapping("/{id}/reviews/{idReview}")
	public ResponseEntity<HttpStatus> deleteReview(@PathVariable int id, @PathVariable int idReview) {
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
