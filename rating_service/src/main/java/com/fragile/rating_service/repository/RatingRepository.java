package com.fragile.rating_service.repository;

import com.fragile.rating_service.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface RatingRepository extends MongoRepository<Rating, String> {

    List<Rating> findByUserId(String ratingId);

    List<Rating> findByHotelId(String hotelId);
}