package com.itszaif.spring.microservices.controllers;

import com.itszaif.spring.microservices.exceptions.UserNotFoundException;
import com.itszaif.spring.microservices.models.User;
import com.itszaif.spring.microservices.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UserResource
{

    //retreive All users
    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers()
    {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    //Get /Users/{id}
    @GetMapping("/users/{id}")
    public Resource<User> retrieveUser(@PathVariable int id)
    {
        User user = service.findOne(id);
        if(user == null)
        {
            throw new UserNotFoundException("id: " + id);
        }

        Resource<User> resource = new Resource<>(user);

        ControllerLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
        resource.add(link.withRel("all-users"));
        return resource;
    }

    // input - details of user
    // output - CREATED & Return the created URI
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user)
    {
        User savedUser = service.saveUser(user);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                                             .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id)
    {
        User user = service.deleteUser(id);

        if(user == null)
        {
            throw new UserNotFoundException("id: " + id);
        }
    }
}
