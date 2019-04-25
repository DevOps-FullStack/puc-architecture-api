package br.com.pucminas.architeture.api.repositories;

import java.util.List;

import br.com.pucminas.architeture.api.models.Book;

public interface IBookRepository extends IRepository<Book> {
	List<Book> findAllByNameOrYear(String name, int year);

	boolean addAuthor(int id, int idAuthor);

	boolean deleteAuthor(int id, int idAuthor);
}
