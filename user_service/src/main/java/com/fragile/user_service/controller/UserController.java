package com.fragile.user_service.controller;

import com.fragile.user_service.entities.User;
import com.fragile.user_service.payload.ApiResponse;
import com.fragile.user_service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = userService.createUser(user);
        return  ResponseEntity.status(HttpStatus.CREATED).body(newUser);

    }

    @GetMapping("/{userId}")
    public  ResponseEntity<User> getSingleUser(@PathVariable("userId") String uuid){
        User foundUser = userService.getUser(uuid) ;
        return ResponseEntity.status(HttpStatus.OK).body(foundUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

}
