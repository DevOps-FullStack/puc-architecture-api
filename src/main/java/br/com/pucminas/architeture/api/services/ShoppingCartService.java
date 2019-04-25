package br.com.pucminas.architeture.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.pucminas.architeture.api.models.Book;
import br.com.pucminas.architeture.api.models.Order;
import br.com.pucminas.architeture.api.models.ShoppingCart;
import br.com.pucminas.architeture.api.models.Status;
import br.com.pucminas.architeture.api.repositories.IShoppingCartRepository;

public class ShoppingCartService implements IShoppingCartService {

	@Autowired
	private IShoppingCartRepository repository;
	@Autowired
	private IBookService bookService;

	@Override
	public List<ShoppingCart> findAll() {
		return repository.findAll();
	}

	@Override
	public ShoppingCart findById(int id) {
		return repository.findById(id);
	}

	@Override
	public ShoppingCart newModel(ShoppingCart model) {
		return repository.newModel(model);
	}

	@Override
	public ShoppingCart updateModel(int id, ShoppingCart model) {
		ShoppingCart shoppingCart = findById(id);
		if (shoppingCart == null)
			return null;
		return repository.updateModel(model);
	}

	@Override
	public boolean deleteModel(int id) {
		return repository.deleteModel(id);
	}

	@Override
	public List<Book> findBooks(int id) {
		ShoppingCart cart = findById(id);

		if (cart.getBooks() == null || cart.getBooks().size() < 1)
			return null;

		return bookService.findById(cart.getBooks());
	}

	@Override
	public Book findBook(int id, int idBook) {
		ShoppingCart cart = findById(id);

		if (cart == null)
			return null;

		Optional<Integer> bookId = cart.getBooks().stream().filter(a -> a == idBook).findFirst();

		if (bookId.isPresent())
			return bookService.findById(bookId.get());
		return null;
	}

	@Override
	public boolean addBook(int id, int idBook) {
		ShoppingCart cart = findById(id);

		if (cart == null)
			return false;

		Book book = bookService.findById(idBook);

		if (book == null)
			return false;

		cart.getBooks().add(idBook);

		return true;
	}

	@Override
	public boolean removeBook(int id, int idBook) {
		Book book = findBook(id, idBook);

		if (book == null)
			return false;

		return findById(id).getBooks().removeIf(a -> a == idBook);
	}

	@Override
	public Order findOrder(int id) {

		ShoppingCart cart = findById(id);

		return cart.getOrder();
	}

	@Override
	public Order updateOrder(int id, Order order) {

		ShoppingCart cart = findById(id);

		if (cart == null)
			return null;

		cart.setOrder(order);

		return order;
	}

	@Override
	public boolean deleteOrder(int id) {
		ShoppingCart cart = findById(id);

		cart.setOrder(null);

		return true;
	}

	@Override
	public Order updateOrderStatus(int id, Status status) {
		Order order = findOrder(id);

		order.setStatus(status);
		return order;
	}

}
