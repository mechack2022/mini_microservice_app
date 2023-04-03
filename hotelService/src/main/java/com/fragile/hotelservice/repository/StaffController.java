package com.fragile.hotelservice.repository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/staff")
@RestController
public class StaffController {

    @GetMapping
    public ResponseEntity<List<String>> getStafflList() {
        List<String> list = Arrays.asList("Mechack", "Gboyegun", "Lawrence", "Williams");
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
