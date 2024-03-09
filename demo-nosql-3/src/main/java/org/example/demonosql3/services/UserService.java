package org.example.demonosql3.services;

import java.util.List;
import org.example.demonosql3.dtos.UserDto;
import org.example.demonosql3.repositories.UserRepository;
import org.example.demonosql3.repositories.UserRepositoryImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> findAll(){
        return userRepository.findAll();
    }

    public List<UserDto> findAllByNameContains(String query){
        return userRepository.findAllByNameContains(query);
    }

    /*


    public Iterable<User> getAllUsers(){
        return usersRepository.findAll();
    }

    public User getById(Long id) {
        if(usersRepository.existsById(id)){
            return usersRepository.findById(id).get();
        } else {
            throw new LauraException("No se encontró el usuario.", null);
        }
    }

    public User insertUser(UserDto user){
        User userdto = User.builder()
            .name(user.getName())
            .password(user.getPassword())
            .build();
        return usersRepository.save(userdto);
    }

    public User updateUser(User user, Long id){

        if(usersRepository.existsById(id)){
            User updateUser = User.builder()
                .id(id)
                .name(user.getName())
                .password(user.getPassword())
                .build();
            return usersRepository.save(updateUser);
        }
        else {
            throw new LauraException("El usuario que desea actualizar no existe.", null);
        }
    }


    public void deleteUser(Long id){
        if(usersRepository.existsById(id)){
            usersRepository.deleteById(id);
        } else{
            throw new LauraException("No se encontró el usuario a eliminar.",null);
        }
    }*/
}
