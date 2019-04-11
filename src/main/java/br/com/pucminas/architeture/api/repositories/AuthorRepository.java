package br.com.pucminas.architeture.api.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.pucminas.architeture.api.models.Author;

@Service
public class AuthorRepository implements IAuthorRepository {

	private List<Author> models;

	public AuthorRepository() {
		models = new ArrayList<Author>();
		models.add(new Author(1, "Giovani"));
		models.add(new Author(2, "Felipe"));
	}

	@Override
	public List<Author> findAll() {

		return models;
	}

	@Override
	public Author findById(int id) {
		Optional<Author> result = models.stream().filter(a -> a.getId() == id).findAny();
		if (result.isPresent())
			return result.get();

		return null;
	}

	@Override
	public Author newModel(Author model) {
		model = new Author(models.size() + 1, model.getName());
		models.add(model);
		return model;
	}

	@Override
	public Author updateModel(Author model) {
		ListIterator<Author> iterator = models.listIterator();
		Author response = null;
		while (iterator.hasNext()) {
			Author result = iterator.next();
			if (result.getId() == model.getId()) {
				iterator.set(model);
				response = model;
			}
		}
		return response;
	}

	@Override
	public boolean deleteModel(int id) {
		return models.removeIf(a -> a.getId() == id);
	}

	@Override
	public List<Author> findByName(String name) {
		return models.stream().filter(a -> a.getName().contains(name)).collect(Collectors.toList());
	}
}
