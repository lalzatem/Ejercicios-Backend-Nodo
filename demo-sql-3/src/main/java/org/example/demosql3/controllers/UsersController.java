package org.example.demosql3.controllers;

import org.example.demosql3.dtos.UserDto;
import org.example.demosql3.models.User;
import org.example.demosql3.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public Iterable<User> getAll(){
        return usersService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getByID(@PathVariable Long id){
        return usersService.getById(id);
    }

    @PostMapping("/users/insert")
    public ResponseEntity<User> insertUser(@RequestBody UserDto user){
        return new ResponseEntity<>(usersService.insertUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id){
        return new ResponseEntity<>(usersService.updateUser(user, id), HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        usersService.deleteUser(id);
    }


}
