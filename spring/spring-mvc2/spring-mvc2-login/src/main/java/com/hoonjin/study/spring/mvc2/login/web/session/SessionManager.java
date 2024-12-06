package com.hoonjin.study.spring.mvc2.login.web.session;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SessionManager {

    private static final String SESSION_COOKIE_NAME = "mySessionId";

    private final Map<String, Object> store = new ConcurrentHashMap<>();

    public void createSession(Object value, HttpServletResponse response) {
        // create session id & save session id to store
        String uuid = UUID.randomUUID().toString();
        store.put(uuid, value);

        Cookie cookie = new Cookie(SESSION_COOKIE_NAME, uuid);
        response.addCookie(cookie);
    }

    public Object getSession(HttpServletRequest request) {
        Optional<Cookie> cookie = getCookie(request);
        if (cookie.isEmpty())
            return null;
        return store.get(cookie.get().getValue());
    }

    public void expireSession(HttpServletRequest request) {
        getCookie(request)
                .ifPresent(c -> store.remove(c.getValue()));
    }

    private Optional<Cookie> getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null)
            return Optional.empty();
        return Arrays.stream(cookies).filter(cookie -> cookie.getName().equals(SESSION_COOKIE_NAME))
                .findAny();
    }
}
