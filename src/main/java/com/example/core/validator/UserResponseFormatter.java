package com.example.core.validator;

import com.example.core.model.response.UserResponseModel;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ApplicationScoped
public class UserResponseFormatter implements UserPresenter{

    @Override
    public UserResponseModel prepareSuccessView(final UserResponseModel user) {
        LocalDateTime responseTime = LocalDateTime.parse(user.getCreationTime());
        user.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return user;
    }

    @Override
    public UserResponseModel prepareFailView(final String error) {
        throw new RuntimeException(error);
    }

}
