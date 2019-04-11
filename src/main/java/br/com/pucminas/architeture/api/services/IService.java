package br.com.pucminas.architeture.api.services;

import java.util.List;

public interface IService<T> {

	List<T> findAll();

	T findById(int id);

	T newModel(T model);

	T updateModel(int id, T model);

	boolean deleteModel(int id);
}
