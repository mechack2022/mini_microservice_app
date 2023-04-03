package com.fragile.rating_service.services;

import com.fragile.rating_service.entities.Rating;
import com.fragile.rating_service.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RatingServiceIpm implements RatingServices {

    private final RatingRepository ratingRepository;
    private final RestTemplate restTemplate;
    @Override
    public Rating createRating(Rating rating) {
        String generatedId = UUID.randomUUID().toString();
        rating.setRatingId(generatedId);
        return  ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatingByUserID(String userId) {
        return ratingRepository.findByUserId(userId);

    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
