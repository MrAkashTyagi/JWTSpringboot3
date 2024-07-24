package com.jwt.example.Service;

import com.jwt.example.entities.User;
import com.jwt.example.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    private List<User> store = new ArrayList<>();

//    public UserService() {
//
//        store.add(new User(UUID.randomUUID().toString(),"Akash Tyagi","akash@gmail.com"));
//        store.add(new User(UUID.randomUUID().toString(),"Anuj","anuj@gmail.com"));
//        store.add(new User(UUID.randomUUID().toString(),"Vishu","vishu@gmail.com"));
//        store.add(new User(UUID.randomUUID().toString(),"Abdul","Abdul@gmail.com"));
//    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User createUser(User user) {

        user.setUserId(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepo.save(user);

    }


}
