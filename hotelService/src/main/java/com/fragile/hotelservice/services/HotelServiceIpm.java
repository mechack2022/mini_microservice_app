package com.fragile.hotelservice.services;

import com.fragile.hotelservice.entities.Hotel;
import com.fragile.hotelservice.exceptions.ResourceNotFoundException;
import com.fragile.hotelservice.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelServiceIpm implements HotelService {

    private final HotelRepository hotelRepository;
    @Override
    public Hotel saveHotel(Hotel hotel) {
        String generatedId = UUID.randomUUID().toString();
        hotel.setHotelId(generatedId);
        return hotelRepository.save((hotel));
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()->
                new ResourceNotFoundException("hotel not found with this id " + hotelId));
    }
}
