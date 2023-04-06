package com.fragile.user_service.external_services;

import com.fragile.user_service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {

    @GetMapping("/ratings/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUser(@PathVariable("userId") String userId);
}
