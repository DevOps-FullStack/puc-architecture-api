package br.com.pucminas.architeture.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pucminas.architeture.api.models.Review;
import br.com.pucminas.architeture.api.repositories.IReviewRepository;
@Service
public class ReviewService implements IReviewService {

	@Autowired
	private IReviewRepository repository;

	@Override
	public List<Review> findAll() {
		return repository.findAll();
	}

	@Override
	public Review findById(int id) {

		return repository.findById(id);
	}

	@Override
	public Review newModel(Review model) {

		return repository.newModel(model);
	}

	@Override
	public Review updateModel(int id, Review model) {

		return repository.updateModel(model);
	}

	@Override
	public boolean deleteModel(int id) {

		return repository.deleteModel(id);
	}

	@Override
	public List<Review> findAllByBook(int id) {

		return repository.findAllByBook(id);
	}

}
