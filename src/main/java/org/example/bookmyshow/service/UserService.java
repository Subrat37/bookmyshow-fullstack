package org.example.bookmyshow.service;

import lombok.RequiredArgsConstructor;
import org.example.bookmyshow.dto.LoginRequest;
import org.example.bookmyshow.dto.UserRequest;
import org.example.bookmyshow.entity.User;
import org.example.bookmyshow.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //it's a lombok annotation it can create construcuter atomatically for repository object.
public class UserService {
    private final UserRepository userRepository;

    //register
    public User register(UserRequest request){
        if (userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exists "+request.getEmail());
        }
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .phone(request.getPhone())
                .build();
        return userRepository.save(user);
    }

    //login
    public User login(LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(()->new RuntimeException("User not Found with email "+request.getEmail()));
        if (!user.getPassword().equals(request.getPassword())){
            throw new RuntimeException("Invalid password");
        }
        return user;
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public User getUserById(Integer id){
        return userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User not found with id "+id));
    }
}
