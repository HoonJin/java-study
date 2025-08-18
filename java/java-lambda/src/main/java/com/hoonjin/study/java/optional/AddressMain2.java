package com.hoonjin.study.java.optional;

import com.hoonjin.study.java.optional.model.Address;
import com.hoonjin.study.java.optional.model.User;

import java.util.Optional;

public class AddressMain2 {

    public static void main(String[] args) {
        User user1 = new User("user1", null);
        User user2 = new User("user2", new Address("hello street"));

        printStreet(user1);
        printStreet(user2);
    }

    private static void printStreet(User user) {
        getUserStreet(user).ifPresentOrElse(
            street -> System.out.println("userStreet = " + street),
            () -> System.out.println("userStreet is UNKNOWN")
        );

    }

    static Optional<String> getUserStreet(User user) {
        return Optional.ofNullable(user)
            .map(User::getAddress)
            .map(Address::getStreet);
    }
}
