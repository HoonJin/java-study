package com.hoonjin.study.spring.rest1.user;

import com.hoonjin.study.spring.rest1.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Kenneth", new Date(), "pw1", "111111-1234567"));
        users.add(new User(2, "Alice", new Date(), "pw2", "222222-1234567"));
        users.add(new User(3, "Elena", new Date(), "pw3", "333333-1234567"));
    }

    public List<User> findAll() {
        return users;
    }

    public int count() {
        return users.size();
    }

    public User save(User user) {
        if (user.getId() == null) {
            int size = count();
            user.setId(++size);
        }
        if (user.getJoinDate() == null) {
            user.setJoinDate(new Date());
        }

        if (users.stream().map(User::getId).anyMatch(id -> id.equals(user.getId()))) {
            throw new IllegalArgumentException("Id 중복");
        }

        users.add(user);
        return user;
    }

    public User findOne(Integer id) {
        return users.stream().filter(u -> u.getId().equals(id))
            .findAny().orElse(null);
    }

    public User deleteById(Integer id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();

            if (user.getId().equals(id)) {
                iterator.remove();
                return user;
            }
        }

        throw new UserNotFoundException("NOT FOUND USER " + id);
    }
}
