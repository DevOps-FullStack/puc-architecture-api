package br.com.pucminas.architeture.api.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.pucminas.architeture.api.models.Review;

@Service
public class ReviewRepository implements IReviewRepository {

	private static List<Review> models = new ArrayList<Review>();

	static {
		models.add(new Review(1, "Review 1", 1));
		models.add(new Review(2, "Review 2", 2));
	}

	@Override
	public List<Review> findAll() {
		return models;
	}

	@Override
	public Review findById(int id) {
		Optional<Review> review = models.stream().filter(a -> a.getId() == id).findFirst();

		if (review.isPresent())
			return review.get();
		return null;
	}

	@Override
	public Review newModel(Review model) {
		Review review = new Review(models.size() + 1, model.getDescrition(), model.getIdBook());
		models.add(review);
		return review;
	}

	@Override
	public Review updateModel(Review model) {
		ListIterator<Review> iterator = models.listIterator();

		Review response = null;

		while (iterator.hasNext()) {
			Review result = iterator.next();
			if (result.getId() == model.getId()) {
				iterator.set(model);
				response = model;
			}
		}
		return response;
	}

	@Override
	public boolean deleteModel(int id) {
		// TODO Auto-generated method stub
		return models.removeIf(a -> a.getId() == id);
	}

	@Override
	public List<Review> findAllByBook(int id) {

		return models.stream().filter(a -> a.getIdBook() == id).collect(Collectors.toList());
	}

}
