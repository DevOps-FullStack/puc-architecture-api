package br.com.pucminas.architeture.api.repositories;

import java.util.List;

public interface IRepository<T> {
	List<T> findAll();

	T findById(int id);

	T newModel(T model);

	T updateModel(T model);

	boolean deleteModel(int id);
}
