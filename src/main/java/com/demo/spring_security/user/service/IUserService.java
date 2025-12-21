package com.demo.spring_security.user.service;

import com.demo.spring_security.user.dto.UserDto;

public interface IUserService {
    UserDto register(UserDto userDto);

    String verify(UserDto userDto);
}
