package com.example.basicspringsecurity.controller;

import com.example.basicspringsecurity.enums.UserRole;
import com.example.basicspringsecurity.service.UserService;
import com.example.basicspringsecurity.vo.UserVO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    private final UserService userService;

    @NonNull
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping(value = "/loginView")
    public String loginView(){
        return "user/login";
    }

    /*
    @PostMapping(value = "/login")
    public String login(HttpServletRequest request, RedirectAttributes redirectAttributes, @ModelAttribute UserVO userVO){
        log.error("@@@");
        String userPw = userVO.getUserPw();
        userVO = userService.findUserByUserEmail(userVO.getUserEmail());
        if(userVO == null || !passwordEncoder.matches(userPw, userVO.getUserPw())){
            redirectAttributes.addFlashAttribute("rsMsg", "아이디 또는 비밀번호가 잘못되었습니다.");
            return "redirect:/user/loginView";
        }
        request.getSession().setAttribute("userVO", userVO);
        return "redirect:/index";
    }
    */


    @GetMapping(value = "/init")
    public String createAdmin(@ModelAttribute UserVO userVO){
        userVO.setUserEmail("user@naver.com");
        userVO.setUserPw(passwordEncoder.encode("test"));
        userVO.setRole(UserRole.USER);
        if(userService.createUser(userVO) == null){
            log.error("Create Admin Error");
        }

        userVO.setUserEmail("admin@naver.com");
        userVO.setUserPw(passwordEncoder.encode("test"));
        userVO.setRole(UserRole.ADMIN);
        if(userService.createUser(userVO) == null){
            log.error("Create Admin Error");
        }
        return "redirect:/index";
    }

}
