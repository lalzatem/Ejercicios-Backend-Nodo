package org.example.demonosql3.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.apache.catalina.User;
import org.example.demonosql3.dtos.UserDto;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

@Repository
public class UserRepositoryImplementation implements UserRepository {

    private final List<UserDto> database;

    public UserRepositoryImplementation() {
        this.database = loadDataBase();
    }

    @Override
    public List<UserDto> findAllByNameContains(String query) {
        return database.stream().filter(userDto -> isContains(query, userDto)).toList();
    }

    private static boolean isContains(String query, UserDto userDto) {
        return userDto.getFirstName().toUpperCase().contains(query.toUpperCase());
    }

    @Override
    public List<UserDto> findAll() {
        return database;
    }

    public UserDto findFirstOne(){
        return loadOneData();
    }

    private List<UserDto> loadDataBase(){
        File file = getFile("classpath:Users.json");
        if (Objects.nonNull(file)){
            return getUserDtos(file);
        }
        return List.of();
    }

    private UserDto loadOneData(){
        File file = getFile("classpath:User.json");
        if (Objects.nonNull(file)){
            return getUserDto(file);
        }
        return UserDto.builder().build();
    }

    private static File getFile(String path) {
        File file = null;
        try {
            file = ResourceUtils.getFile(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return file;
    }


    private static List<UserDto> getUserDtos(File file) {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<UserDto>> typeRef = new TypeReference<>(){};
        try {
            return mapper.readValue(file, typeRef);
        } catch (IOException e) {
            return List.of();
        }
    }

    private static UserDto getUserDto(File file) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(file, UserDto.class);
        } catch (IOException e) {
            return UserDto.builder().build();
        }
    }



}
