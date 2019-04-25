package br.com.pucminas.architeture.api.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.pucminas.architeture.api.services.IShoppingCartService;

@RestController("shopping-carts")
@RequestMapping(path = "/api/v1/shopping-carts", produces = "application/json")
public class ShoppingCartsController {

	@Autowired
	private IShoppingCartService service;

	@GetMapping
	public ResponseEntity<List<ShoppingCart>> all(@RequestParam(required = false) LocalDateTime dateStart,
			@RequestParam(required = false) LocalDateTime dateEnd, @RequestParam Status status) {

		List<ShoppingCart> itens = service.findAll();
		if (itens == null || itens.size() < 1)
			return new ResponseEntity<List<ShoppingCart>>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<ShoppingCart>>(itens, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ShoppingCart> findById(@PathVariable int id) {
		ShoppingCart item = service.findById(id);
		if (item == null)
			return new ResponseEntity<ShoppingCart>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<ShoppingCart>(item, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ShoppingCart> update(@PathVariable int id, @RequestBody ShoppingCart shoppingCart) {
		ShoppingCart item = service.updateModel(id, shoppingCart);
		if (item == null)
			return new ResponseEntity<ShoppingCart>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<ShoppingCart>(item, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
		if (service.deleteModel(id))
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{id}/books")
	public ResponseEntity<List<Book>> allBooks(@PathVariable int id) {
		List<Book> books = service.findBooks(id);
		if (books == null || books.size() < 1)
			return new ResponseEntity<List<Book>>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@GetMapping("/{id}/books/{idBook}")
	public ResponseEntity<Book> findByIdBook(@PathVariable int id, @PathVariable int idBook) {
		Book book = service.findBook(id, idBook);
		if (book == null)
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@PutMapping("/{id}/books/{idBook}")
	public ResponseEntity<HttpStatus> addBook(@PathVariable int id, @RequestBody int idBook) {

		if (service.addBook(id, idBook))
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}/books/{idBook}")
	public ResponseEntity<HttpStatus> removeBook(@PathVariable int id, @PathVariable int idBook) {
		if (service.removeBook(id, idBook))
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{id}/orders")
	public ResponseEntity<Order> getOrder(@PathVariable int id) {
		Order order = service.findOrder(id);

		if (order == null)
			return new ResponseEntity<Order>(order, HttpStatus.OK);
		return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}/orders")
	public ResponseEntity<Order> updateOrder(@PathVariable int id, @RequestBody Order order) {
		order = service.updateOrder(id, order);
		if (order == null)
			return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

	@DeleteMapping("/{id}/orders")
	public ResponseEntity<HttpStatus> deleteOrder(@PathVariable int id) {

		if (service.deleteOrder(id))
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);

		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}/orders/status")
	public ResponseEntity<Order> updateOrderStatus(@PathVariable int id, @RequestBody Status status) {

		Order order = service.updateOrderStatus(id, status);
		if (order == null)
			return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
}
