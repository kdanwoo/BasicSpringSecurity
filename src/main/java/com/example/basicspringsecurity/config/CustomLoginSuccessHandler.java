package com.example.basicspringsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    /**
     * CustomLoginSuccessHandler는 AuthenticationProvider를 통해 인증이 성공될 경우 처리되는데,
     * 이번 예제에서는 /about 요청으로 redirect되도록 해주었다.
     * 그리고 토큰을 사용하지 않고 세션을 활용하는 지금 예제같은 경우에는 성공하여 반환된 Authentication 객체를
     * SecurityContextHolder의 Contetx에 저장해주어야 한다. 나중에 사용자의 정보를 꺼낼 경우에도 SecurityContextHolder의 context에서 조회하면 된다.
     *
     * */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException {
        SecurityContextHolder.getContext().setAuthentication(authentication);
        response.sendRedirect("/about");
    }
}
