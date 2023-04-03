package com.fragile.hotelservice.services;

import com.fragile.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {


    Hotel saveHotel(Hotel hotel);

    List<Hotel>  getAllHotels();

    Hotel getHotel(String hotelId);
}
