package org.example.demonosql3.repositories;

import java.util.List;
import org.example.demonosql3.dtos.UserDto;

public interface UserRepository {

    List<UserDto> findAllByNameContains(String query);

    List<UserDto> findAll();
}
