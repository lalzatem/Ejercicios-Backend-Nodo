package org.example.crudmongo.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class UserRequestDto {

    private String id;
    @JsonAlias("first_name")
    private String firstName;
    @JsonAlias("last_name")
    private String lastName;
    private String email;
    private String gender;
}
