package com.example.bank.mapper;

import com.example.bank.mapper.core.BaseMapper;
import com.example.bank.model.user.User;
import com.example.bank.model.user.UserRequestDTO;
import com.example.bank.model.user.UserResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements BaseMapper<User, UserRequestDTO, UserResponseDTO> {

    @Override
    public User toEntity(UserRequestDTO userRequestDTO) {
        User user = new User();
        this.toEntity(userRequestDTO, user);
        return user;
    }

    @Override
    public void toEntity(UserRequestDTO userRequestDTO, User user) {

        user.setId(userRequestDTO.getId());
        user.setPassword(userRequestDTO.getPassword());
        user.setUserName(userRequestDTO.getUserName());
        user.setFullName(userRequestDTO.getFullName());

    }

    @Override
    public UserResponseDTO toDTO(User user) {

        UserResponseDTO userResponseDTO = UserResponseDTO.builder().build();
        this.toDTO(user, userResponseDTO);
        return userResponseDTO;
    }

    @Override
    public void toDTO(User user, UserResponseDTO userResponseDTO){

        userResponseDTO.setId(user.getId());
        userResponseDTO.setUserName(user.getUserName());
        userResponseDTO.setUserName(user.getUserName());

        setBaseField(userResponseDTO, user);
    }

}
