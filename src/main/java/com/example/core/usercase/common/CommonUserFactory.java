package com.example.core.usercase.common;

import com.example.core.usercase.User;
import com.example.core.usercase.UserFactory;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CommonUserFactory implements UserFactory {

    @Override
    public User create(final String name, final String password) {
        return new CommonUser(name, password);
    }

}
