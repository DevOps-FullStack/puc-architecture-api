package br.com.pucminas.architeture.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.pucminas.architeture.api.services.IAuthorService;
import br.com.pucminas.architeture.api.services.IBookService;
import br.com.pucminas.architeture.api.services.IReviewService;

@RestController("books")
@RequestMapping(path = "/api/v1/books", produces = "application/json")
public class BooksController {
	@Autowired
	private IBookService service;
	@Autowired
	private IAuthorService authorService;
	@Autowired
	private IReviewService reviewService;

	@GetMapping
	public ResponseEntity<List<Book>> all(@RequestParam(required = false) String name,
			@RequestParam(required = false) int year) {

		List<Book> books = service.findByNameOrYear(name, year);
		if (books == null || books.size() < 1)
			return new ResponseEntity<List<Book>>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> findById(@PathVariable int id) {
		Book book = service.findById(id);

		if (book == null)
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Book> newBook(@RequestBody Book book) {
		return new ResponseEntity<Book>(book, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book model) {
		Book book = service.updateModel(id, model);
		if (book == null)
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Book>(book, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable int id) {
		if (service.deleteModel(id))
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{id}/authors")
	public ResponseEntity<List<Author>> allAuthors(@PathVariable int id, @RequestParam(required = false) String name) {
		List<Author> authors = null;
		Book book = service.findById(id);

		authors = authorService.findAllByIdOrName(book.getAuthors(), name);

		if (authors == null || authors.size() < 1)
			return new ResponseEntity<List<Author>>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Author>>(authors, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{id}/authors/{idAuthor}")
	public ResponseEntity<Author> findByIdAuthor(@PathVariable int id, @PathVariable int idAuthor) {
		Author author = service.findAuthorById(id, idAuthor);
		if (author != null)
			return new ResponseEntity<Author>(author, HttpStatus.OK);
		return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}/authors/{idAuthor}")
	public ResponseEntity<HttpStatus> addAuthor(@PathVariable int id, @PathVariable int idAuthor) {

		if (service.addAuthor(id, idAuthor))
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}/authors/{idAuthor}")
	public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable int id, @PathVariable int idAuthor) {
		if (service.deleteAuthor(id, idAuthor))
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{id}/reviews")
	public ResponseEntity<List<Review>> allReviews(@PathVariable int id) {
		List<Review> result = reviewService.findAllByBook(id);

		if (result == null)
			return new ResponseEntity<List<Review>>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<List<Review>>(result, HttpStatus.OK);
	}

	@GetMapping("/{id}/reviews/{idReview}")
	public ResponseEntity<Review> findByIdReview(@PathVariable int id, @PathVariable int idReview) {
		Review result = service.findReviewByBook(id, idReview);

		if (result == null)
			return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Review>(result, HttpStatus.OK);
	}

	@PutMapping("/{id}/reviews")
	public ResponseEntity<Review> newReview(@PathVariable int id, @RequestBody Review review) {
		Review result = service.newReview(id, review);

		if (result == null)
			return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Review>(result, HttpStatus.OK);
	}

	@PutMapping("/{id}/reviews/{idReview}")
	public ResponseEntity<Review> updateReview(@PathVariable int id, @PathVariable int idReview,
			@RequestBody Review review) {
		Review result = service.updateReviewByBook(id, idReview, review);

		if (review == null)
			return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Review>(result, HttpStatus.OK);
	}

	@DeleteMapping("/{id}/reviews/{idReview}")
	public ResponseEntity<HttpStatus> deleteReview(@PathVariable int id, @PathVariable int idReview) {

		if (service.deleteReview(id, idReview))
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}
}
