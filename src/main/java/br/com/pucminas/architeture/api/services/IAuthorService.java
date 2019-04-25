package br.com.pucminas.architeture.api.services;

import java.util.List;

import br.com.pucminas.architeture.api.models.Author;

public interface IAuthorService extends IService<Author> {
	List<Author> findByName(String name);

	List<Author> findAllByIdOrName(List<Integer> id, String name);
}
