package com.itszaif.spring.microservices.controllers;

import com.itszaif.spring.microservices.models.User;
import com.itszaif.spring.microservices.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource
{

    //retreive All users
    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> getAllUsers()
    {
        return service.findAll();
    }

    //Get /Users/{id}
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id)
    {
        return service.findOne(id);
    }

    // input - details of user
    // output - CREATED & Return the created URI
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user)
    {
        User savedUser = service.saveUser(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                                             .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
