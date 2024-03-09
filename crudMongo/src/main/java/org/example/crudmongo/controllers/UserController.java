package org.example.crudmongo.controllers;

import java.util.List;
import org.example.crudmongo.dtos.UserRequestDto;
import org.example.crudmongo.models.User;
import org.example.crudmongo.services.UserService;
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
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<?> getAll() {
        List<User> response = userService.findAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{firstname}/firstname")
    public ResponseEntity<?> getByFirstNameContains(@PathVariable String firstname){
        //List<User> response = userService.findByFirstNameContains(firstname);
        List<User> response = userService.findByFirstNameContainsOperation(firstname);
        if(!response.isEmpty()){
            return ResponseEntity.ok(response);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRequestDto request){
        userService.saveUser(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@RequestBody User request, @PathVariable String id){
        userService.updateUser(request,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
