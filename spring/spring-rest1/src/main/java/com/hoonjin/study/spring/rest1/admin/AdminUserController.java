package com.hoonjin.study.spring.rest1.admin;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.hoonjin.study.spring.rest1.exception.UserNotFoundException;
import com.hoonjin.study.spring.rest1.user.User;
import com.hoonjin.study.spring.rest1.user.UserDaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminUserController {

    private final UserDaoService userDaoService;

    @GetMapping("/users")
    public MappingJacksonValue retrieveAllUsers() {
        List<User> users = userDaoService.findAll();
        List<AdminUser> adminUsers = new ArrayList<>();

        for (User user : users) {
            AdminUser adminUser = new AdminUser();
            BeanUtils.copyProperties(user, adminUser);

            adminUsers.add(adminUser);
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate");
        SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(adminUsers);
        mapping.setFilters(filters);
        return  mapping;
    }

//    @GetMapping(value = "/users/{id}", params = "version=1")
//    @GetMapping(value = "/users/{id}", headers = "X-API-VERSION=1")
    @GetMapping(value = "/users/{id}", produces = "application/vnd.company.appv1.json")
    public MappingJacksonValue retrieveUser1(@PathVariable Integer id) {
        System.out.println("id = " + id);
        User user = userDaoService.findOne(id);

        AdminUser adminUser = new AdminUser();
        if (user == null) {
            throw new UserNotFoundException("not found user " + id);
        } else {
            BeanUtils.copyProperties(user, adminUser);
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "ssn");
        SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(adminUser);
        mapping.setFilters(filters);
        return  mapping;
    }

//    @GetMapping(value = "/users/{id}", params = "version=2")
//    @GetMapping(value = "/users/{id}", headers = "X-API-VERSION=2")
    @GetMapping(value = "/users/{id}", produces = "application/vnd.company.appv2.json")
    public MappingJacksonValue retrieveUser2(@PathVariable Integer id) {
        System.out.println("id = " + id);
        User user = userDaoService.findOne(id);

        AdminUserV2 adminUser = new AdminUserV2();
        if (user == null) {
            throw new UserNotFoundException("not found user " + id);
        } else {
            BeanUtils.copyProperties(user, adminUser);
            adminUser.setGrade("VIP");
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "grade");
        SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("UserInfoV2", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(adminUser);
        mapping.setFilters(filters);
        return  mapping;
    }

    @GetMapping("/v1/users/{id}")
    public MappingJacksonValue retrieveUserV1(@PathVariable Integer id) {
        User user = userDaoService.findOne(id);

        AdminUserV2 adminUser = new AdminUserV2();
        System.out.println("adminUser = " + adminUser);
        if (user == null) {
            throw new UserNotFoundException("not found user " + id);
        } else {
            BeanUtils.copyProperties(user, adminUser);
            adminUser.setGrade("VIP");
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "grade");
        SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("UserInfoV2", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(adminUser);
        mapping.setFilters(filters);
        return  mapping;
    }
}
