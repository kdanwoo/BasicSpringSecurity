package com.example.basicspringsecurity.service;

import com.example.basicspringsecurity.repository.UserRepository;
import com.example.basicspringsecurity.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserVO login(UserVO userVO) {
        return userRepository.findByUserEmailAndUserPw(userVO.getUserEmail(), userVO.getUserPw());
    }

    @Override
    public UserVO createUser(UserVO userVO) {
        return userRepository.save(userVO);
    }

    @Override
    public UserVO findUserByUserEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail).get();
    }
}
