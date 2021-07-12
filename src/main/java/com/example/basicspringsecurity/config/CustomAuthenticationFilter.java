package com.example.basicspringsecurity.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 전송이 오면 AuthenticationFilter로 요청이 먼저 오게 되고,
 * 아이디와 비밀번호를 기반으로 UserPasswordAuthenticationToken을 발급해주어야 한다.
 * 프론트 단에서 유효성 검사를 하겠지만, 안전을 위해서 다시 한번 아이디와 패스워드의 유효성 검사를 해주는 것이 좋지만
 * 아래의 예제에서는 생략하도록 하겠다.(아이디나 비밀번호의 null 여부 등) 해당 Filter를 직접 구현하면 아래와 같다.
 *
 * */
@Slf4j
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        UsernamePasswordAuthenticationToken authRequest =
                new UsernamePasswordAuthenticationToken(request.getParameter("userEmail"),request.getParameter("userPw"));

        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);

    }
}
