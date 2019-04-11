package br.com.pucminas.architeture.api.repositories;

import java.util.List;

import br.com.pucminas.architeture.api.models.Author;

public interface IAuthorRepository extends IRepository<Author> {
	List<Author> findByName(String name);
}
