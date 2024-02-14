package org.example.demosql3.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import org.example.demosql3.Exception.LauraException;
import org.example.demosql3.dtos.UserDto;
import org.example.demosql3.models.User;
import org.example.demosql3.repositories.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UsersServiceTest {

  private static final String TEST_STRING = "algo";
  @Mock
  private UsersRepository repository;
  @InjectMocks
  private UsersService service;

  @BeforeEach
  public void setUp(){
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void ShouldReturnAllUsers(){
    //Arrange
    Iterable<User> list = List.of(buildUser());
    when(repository.findAll()).thenReturn(list);

    //Act
    Iterable<User> response =  service.getAllUsers();
    User user = response.iterator().next();

    //Assert
    assertEquals(1L,user.getId());
  }

  @Test
  public void ShouldReturnUserById(){
    //Arrange
    when(repository.existsById(anyLong())).thenReturn(true);
    when(repository.findById(anyLong())).thenReturn(Optional.of(buildUser()));

    //Act
    User user = User.builder()
        .id(1L)
        .name(TEST_STRING)
        .password(TEST_STRING)
        .build();
    user = service.getById(user.getId());

    //Assert
    assertEquals(1L,user.getId());
  }

  @Test
  public void ShouldReturnExceptionUserByIdWhenIdNotExist(){
    //Arrange
    when(repository.findById(anyLong())).thenReturn(null);

    //Act

    //Assert
    assertThrows(LauraException.class,()->service.getById(1L));
  }

  @Test
  public void ShouldReturnUserCreated(){
    //Arrange
    when(repository.save(any(User.class))).thenReturn(buildUser());
    UserDto user = UserDto.builder()
        .name(TEST_STRING)
        .password(TEST_STRING)
        .build();
    //Act
    User response =  service.insertUser(user);

    //Assert
    assertEquals(1L,response.getId());
  }

  @Test
  public void ShouldDeleteUser(){
    //Arrange
    when(repository.existsById(anyLong())).thenReturn(true);
    when(repository.save(any(User.class))).thenReturn(buildUser());
    //Act
    service.deleteUser(1L);

    //Assert
    verify(repository).deleteById(1L);
  }

  @Test
  public void ShouldReturnExceptionDeleteWhenIdNotExist(){
    //Arrange
    when(repository.findById(anyLong())).thenReturn(null);

    //Act

    //Assert
    assertThrows(LauraException.class,()->service.deleteUser(1L));
  }


  //Test que falla
  @Test
  public void ShouldReturnNullUserWhenIdNotExist(){
    //Arrange
    when(repository.existsById(anyLong())).thenReturn(false);

    User user = User.builder().build();
    //Act
    User response =  service.updateUser(user,1L);

    //Assert
    assertNotNull(response);
    assertNull(response.getId());
  }

  @Test
  public void ShouldReturnUserWhenIdExist(){
    //Arrange
    when(repository.existsById(anyLong())).thenReturn(true);
    when(repository.save(any(User.class))).thenReturn(
                User.builder()
                    .id(1L)
                    .name(TEST_STRING)
                    .password(TEST_STRING)
                    .build()
    );
    User user = User.builder()
        .name(TEST_STRING)
        .password(TEST_STRING)
        .build();
    //Act
    User response =  service.updateUser(user,1L);

    //Assert
    assertEquals(1L,response.getId());
  }

  @Test
  public void ShouldReturnNullUpdateUserException(){
    //Arrange
    when(repository.existsById(anyLong())).thenReturn(false);

    User user = User.builder()
        .name(TEST_STRING)
        .password(TEST_STRING)
        .build();
    //Act

    //Assert
    //assertEquals(1L,response.getId());
    assertThrows(LauraException.class,()->service.updateUser(user,1L));
  }

  private User buildUser(){
    return User.builder()
        .id(1L)
        .name(TEST_STRING)
        .password(TEST_STRING)
        .build();
  }
}


