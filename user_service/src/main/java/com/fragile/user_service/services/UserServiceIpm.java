package com.fragile.user_service.services;

import com.fragile.user_service.entities.Hotel;
import com.fragile.user_service.entities.Rating;
import com.fragile.user_service.entities.User;
import com.fragile.user_service.exception.ResourcesNotFoundException;
import com.fragile.user_service.external_services.HotelService;
import com.fragile.user_service.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceIpm implements UserService {


    private final UserRepository userRepository;
    private final HotelService hotelService;
    private final RestTemplate restTemplate;

    @Override
    public User createUser(User user) {
        String generatedId = UUID.randomUUID().toString();
        user.setId(generatedId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userid) {
        User foundUser = userRepository.findById(userid).orElseThrow(() ->
                new ResourcesNotFoundException("User not found with this id" + userid));
//        api call to rating services
        Rating[] userRating = restTemplate.getForObject("http://RATING-SERVICE/ratings/user/" + foundUser.getId(), Rating[].class);
        log.info(" fetching user with  this id {} ", foundUser.getId());

        List<Rating> ratings = Arrays.stream(userRating).toList();
        List<Rating> ratingInList = ratings.stream().map(rating -> {
//                    api call to the hotel service to get the hotel
//                    ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://localhost:8082/hotels/" + rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).toList();

        foundUser.setRatings(ratings);
        return foundUser;
    }
}
