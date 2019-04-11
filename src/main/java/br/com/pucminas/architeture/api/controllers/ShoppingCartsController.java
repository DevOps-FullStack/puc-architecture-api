package br.com.pucminas.architeture.api.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pucminas.architeture.api.models.Book;
import br.com.pucminas.architeture.api.models.Order;
import br.com.pucminas.architeture.api.models.ShoppingCart;
import br.com.pucminas.architeture.api.models.Status;

@RestController("shopping-carts")
@RequestMapping(path = "/api/v1/shopping-carts", produces = "application/json")
public class ShoppingCartsController {

	@GetMapping
	public ResponseEntity<List<ShoppingCart>> all(@RequestParam(required = false) LocalDateTime dateStart,
			@RequestParam(required = false) LocalDateTime dateEnd, @RequestParam Status status) {
		return null;
	}

	@GetMapping("/{id}")
	public ResponseEntity<ShoppingCart> findById(@PathVariable int id) {
		return null;
	}

	@PutMapping("/{id}")
	public ResponseEntity<ShoppingCart> update(@PathVariable int id, @RequestBody ShoppingCart shoppingCart) {
		return null;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@GetMapping("/{id}/books")
	public ResponseEntity<List<Book>> allBooks() {
		return null;
	}

	@GetMapping("/{id}/books/{idBook}")
	public ResponseEntity<ShoppingCart> findByIdBook(@PathVariable int idBook) {
		return null;
	}

	@PutMapping("/{id}/books/{idBook}")
	public ResponseEntity<ShoppingCart> addBook(@PathVariable int id, @RequestBody int idBook) {
		return null;
	}

	@DeleteMapping("/{id}/books/{idBook}")
	public ResponseEntity<HttpStatus> removeBook(@PathVariable int id) {
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@GetMapping("/{id}/orders")
	public ResponseEntity<Order> getOrder(@PathVariable int id) {
		return null;
	}

	@PutMapping("/{id}/orders")
	public ResponseEntity<Order> updateOrder(@PathVariable int id, @RequestBody Order order) {
		return null;
	}

	@DeleteMapping("/{id}/orders")
	public ResponseEntity<HttpStatus> deleteOrder(@PathVariable int id) {
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@PutMapping("/{id}/orders/status")
	public ResponseEntity<Order> updateOrder(@PathVariable int id, @RequestBody Status status) {
		return null;
	}
}
