package com.example.basicspringsecurity.service;

import com.example.basicspringsecurity.vo.UserVO;

public interface UserService {

    UserVO login(UserVO userVO);
    UserVO createUser(UserVO userVO);
    UserVO findUserByUserEmail(String userEmail);
}
