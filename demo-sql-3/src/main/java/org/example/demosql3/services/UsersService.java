package org.example.demosql3.services;

/*
Realizar un crear usuario, obtener usuario por id, actualizar usuario, y borrar usaurio
 */

import org.example.demosql3.Exception.LauraException;
import org.example.demosql3.dtos.UserDto;
import org.example.demosql3.models.User;
import org.example.demosql3.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;


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
    }


}
