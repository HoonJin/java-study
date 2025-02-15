package com.hoonjin.study.spring.mvc2.login.web.login;

import com.hoonjin.study.spring.mvc2.login.domain.login.LoginService;
import com.hoonjin.study.spring.mvc2.login.domain.member.Member;
import com.hoonjin.study.spring.mvc2.login.web.SessionConst;
import com.hoonjin.study.spring.mvc2.login.web.session.SessionManager;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final SessionManager sessionManager;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute LoginForm loginForm) {
        return "login/loginForm";
    }

//    @PostMapping("/login")
    public String login(@Validated @ModelAttribute LoginForm loginForm, BindingResult bindingResult, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }

        log.info("form = {}", loginForm);
        Member member = loginService.login(loginForm.getLoginId(), loginForm.getPassword());
        log.info("member {}", member);

        if (member == null) {
            bindingResult.reject("loginError", "틀렷어 너");
            return "login/loginForm";
        } else {
            // 로그인 성공 처리 -> cookie 를 활용
            Cookie cookie = new Cookie("memberId", String.valueOf(member.getId()));
            response.addCookie(cookie);
            return "redirect:/";
        }
    }

//    @PostMapping("/login")
    public String loginV2(@Validated @ModelAttribute LoginForm loginForm, BindingResult bindingResult, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }

        log.info("form = {}", loginForm);
        Member member = loginService.login(loginForm.getLoginId(), loginForm.getPassword());
        log.info("member {}", member);

        if (member == null) {
            bindingResult.reject("loginError", "틀렷어 너");
            return "login/loginForm";
        } else {
            sessionManager.createSession(member, response);
            return "redirect:/";
        }
    }

//    @PostMapping("/login")
    public String loginV3(@Validated @ModelAttribute LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }

        log.info("form = {}", loginForm);
        Member member = loginService.login(loginForm.getLoginId(), loginForm.getPassword());
        log.info("member {}", member);

        if (member == null) {
            bindingResult.reject("loginError", "틀렷어 너");
            return "login/loginForm";
        } else {
            HttpSession session = request.getSession(); // 세션이 있으면 세션 반환, 없으면 신규 세션 생성
            session.setAttribute(SessionConst.LOGIN_MEMBER, member);
            return "redirect:/";
        }
    }

    @PostMapping("/login")
    public String loginV4(@Validated @ModelAttribute LoginForm loginForm,
                          BindingResult bindingResult,
                          @RequestParam(defaultValue = "/") String redirectURL,
                          HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }

        log.info("form = {}", loginForm);
        Member member = loginService.login(loginForm.getLoginId(), loginForm.getPassword());
        log.info("member {}", member);

        if (member == null) {
            bindingResult.reject("loginError", "틀렷어 너");
            return "login/loginForm";
        } else {
            HttpSession session = request.getSession(); // 세션이 있으면 세션 반환, 없으면 신규 세션 생성
            session.setAttribute(SessionConst.LOGIN_MEMBER, member);
            return "redirect:" + redirectURL;
        }
    }

//    @PostMapping("logout")
    public String logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("memberId", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return "redirect:/";
    }

//    @PostMapping("logout")
    public String logoutV2(HttpServletRequest request) {
        sessionManager.expireSession(request);
        return "redirect:/";
    }

    @PostMapping("logout")
    public String logoutV3(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null)
            session.invalidate();

        return "redirect:/";
    }

}
