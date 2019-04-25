package br.com.pucminas.architeture.api.repositories;

import java.util.List;

import br.com.pucminas.architeture.api.models.Review;

public interface IReviewRepository extends IRepository<Review> {

	List<Review> findAllByBook(int id);

}
