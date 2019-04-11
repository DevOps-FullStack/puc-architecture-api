package br.com.pucminas.architeture.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pucminas.architeture.api.models.Author;
import br.com.pucminas.architeture.api.repositories.IAuthorRepository;

@Service
public class AuthorService implements IAuthorService {

	@Autowired
	private IAuthorRepository repository;

	@Override
	public List<Author> findAll() {
		return repository.findAll();
	}

	@Override
	public Author findById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public Author newModel(Author model) {
		// TODO Auto-generated method stub
		return repository.newModel(model);
	}

	@Override
	public Author updateModel(int id, Author model) {

		Author author = repository.findById(id);

		if (author == null)
			return null;

		return repository.updateModel(author);
	}

	@Override
	public boolean deleteModel(int id) {
		return repository.deleteModel(id);
	}

	@Override
	public List<Author> findByName(String name) {
		return repository.findByName(name);
	}

}
