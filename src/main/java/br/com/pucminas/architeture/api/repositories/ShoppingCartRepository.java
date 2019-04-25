package br.com.pucminas.architeture.api.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.pucminas.architeture.api.models.ShoppingCart;

@Service
public class ShoppingCartRepository implements IShoppingCartRepository {
	private static List<ShoppingCart> models = new ArrayList<ShoppingCart>();

	@Override
	public List<ShoppingCart> findAll() {
		return models;
	}

	@Override
	public ShoppingCart findById(int id) {
		Optional<ShoppingCart> item = models.stream().filter(a -> a.getId() == id).findFirst();
		if (item.isPresent())
			return item.get();
		return null;
	}

	@Override
	public ShoppingCart newModel(ShoppingCart model) {
		ShoppingCart item = new ShoppingCart(models.size() + 1);
		models.add(item);
		return item;
	}

	@Override
	public ShoppingCart updateModel(ShoppingCart model) {
		ListIterator<ShoppingCart> iterator = models.listIterator();

		ShoppingCart response = null;

		while (iterator.hasNext()) {
			ShoppingCart result = iterator.next();
			if (result.getId() == model.getId()) {
				if (model.getOrder() != null)
					result.setOrder(model.getOrder());
				if (model.getBooks() != null)
					result.setBooks(model.getBooks());
				iterator.set(result);
				response = result;
			}
		}
		return response;
	}

	@Override
	public boolean deleteModel(int id) {
		return models.removeIf(a -> a.getId() == id);
	}

}
