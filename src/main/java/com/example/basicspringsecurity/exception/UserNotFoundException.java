package com.example.basicspringsecurity.exception;

/**
 * 아이디를 기반으로 조회한 결과를 반환하기 위해서는 위에서 작성하던 UserDetailsServiceImpl을 마무리해주어야 하는데,
 * 그 전에 사용자의 아이디를 기반으로 데이터가 조회하지 않았을 경우 처리해주기 위한 Exception 클래스를 추가해주어야 한다.
 *
 * */
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String userEmail){
        super(userEmail + " NotFoundException");
    }
}
