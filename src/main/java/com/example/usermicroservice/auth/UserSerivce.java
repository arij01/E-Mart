package com.example.usermicroservice.auth;

import com.example.usermicroservice.Entities.User;
import com.example.usermicroservice.Repository.UserRepository;
import com.example.usermicroservice.UserDTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserSerivce {
    @Autowired
    UserRepository userRepository ;
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserDTO(
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getRole().name()
                ))
                .collect(Collectors.toList());
    }
}
