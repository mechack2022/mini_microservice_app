package com.fragile.user_service.services;

import com.fragile.user_service.entities.User;

import java.util.List;

public interface UserService  {

   User createUser(User user);

   List<User> getAllUsers();

   User getUser(String userid);
}
