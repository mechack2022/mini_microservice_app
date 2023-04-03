package com.fragile.rating_service.services;

import com.fragile.rating_service.entities.Rating;

import java.util.List;

public interface RatingServices {

    Rating createRating(Rating rating);

    List<Rating> getRatingByUserID(String userId);

    List<Rating> getAllRatings();

    List<Rating> getRatingByHotelId(String hotelId);
}
