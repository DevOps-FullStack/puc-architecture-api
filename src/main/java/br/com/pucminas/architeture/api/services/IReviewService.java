package br.com.pucminas.architeture.api.services;

import java.util.List;

import br.com.pucminas.architeture.api.models.Review;

public interface IReviewService extends IService<Review> {

	List<Review> findAllByBook(int id);

}
