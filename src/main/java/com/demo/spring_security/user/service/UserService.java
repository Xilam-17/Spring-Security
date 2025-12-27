package com.demo.spring_security.user.service;

import com.demo.spring_security.user.dto.UserDto;
import com.demo.spring_security.user.model.UserEntity;
import com.demo.spring_security.user.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JWTService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    private UserEntity mapToEntity(UserDto dto) {
        UserEntity user = new UserEntity();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        return user;
    }

    private UserDto mapToDto(UserEntity user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        return dto;
    }

    @Override
    public UserDto register(UserDto userDto) {
        UserEntity user = mapToEntity(userDto);

        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        user.setPassword(encodedPassword);

        UserEntity savedUser = userRepository.save(user);
        return mapToDto(savedUser);
    }

    @Override
    public String verify(UserDto userDto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(),userDto.getPassword()));

        if(authentication.isAuthenticated()) {
           return jwtService.generateToken(userDto.getUsername());
        }
        return "Fail";
    }
}
