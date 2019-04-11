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
import br.com.pucminas.architeture.api.services.IAuthorService;

@RestController("authors")
@RequestMapping(path = "/api/v1/authors", produces = "application/json")
public class AuthorsController {

	@Autowired
	private IAuthorService service;

	@GetMapping
	public ResponseEntity<List<Author>> all(@RequestParam(required = false) String name) {
		if (name != null)
			return new ResponseEntity<List<Author>>(service.findByName(name), HttpStatus.OK);
		return new ResponseEntity<List<Author>>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Author> findById(@PathVariable int id) {
		Author result = service.findById(id);

		if (result == null)
			return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Author>(result, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Author> newAuthor(@RequestBody Author author) {
		return new ResponseEntity<Author>(service.newModel(author), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Author> updateAuthor(@PathVariable int id, @RequestBody Author author) {

		Author result = service.updateModel(id, author);

		if (result == null)
			return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Author>(result, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable int id) {
		if (service.deleteModel(id))
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}

}
