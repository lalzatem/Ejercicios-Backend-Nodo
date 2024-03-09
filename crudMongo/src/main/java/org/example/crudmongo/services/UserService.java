package org.example.crudmongo.services;

import java.util.List;
import org.example.crudmongo.dtos.UserRequestDto;
import org.example.crudmongo.models.User;
import org.example.crudmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoOperations mongoOperations;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findByFirstNameContains(String firstname) {
        return userRepository.findByFirstNameContains(firstname);
    }

    public List<User> findByFirstNameContainsOperation(String firstname) {
        Query query = new Query();
        query.addCriteria(Criteria.where("first_name").regex(firstname));
        return mongoOperations.find(query,User.class);
        //return userRepository.findByFirstNameContains(firstname);
    }

    public void saveUser(UserRequestDto request){
        User userToSave = User.builder()
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .gender(request.getGender())
            .build();
        userRepository.save(userToSave);
    }

    public void updateUser(User request, String id){
        User updateUser = User.builder()
            .id(id)
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .gender(request.getGender())
            .build();
        userRepository.save(updateUser);
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
}
