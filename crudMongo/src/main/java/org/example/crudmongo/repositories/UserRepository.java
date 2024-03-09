package org.example.crudmongo.repositories;

import java.util.List;
import org.example.crudmongo.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    List<User> findByFirstNameContains(String firstname);
}
