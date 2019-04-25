package br.com.pucminas.architeture.api.services;

import java.util.List;

import br.com.pucminas.architeture.api.models.Book;
import br.com.pucminas.architeture.api.models.Order;
import br.com.pucminas.architeture.api.models.ShoppingCart;
import br.com.pucminas.architeture.api.models.Status;

public interface IShoppingCartService extends IService<ShoppingCart> {

	List<Book> findBooks(int id);

	Book findBook(int id, int idBook);

	boolean addBook(int id, int idBook);

	boolean removeBook(int id, int idBook);

	Order findOrder(int id);

	Order updateOrder(int id, Order order);

	boolean deleteOrder(int id);

	Order updateOrderStatus(int id, Status status);

}
