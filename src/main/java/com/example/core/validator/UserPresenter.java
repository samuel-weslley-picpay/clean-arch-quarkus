package com.example.core.validator;

import com.example.core.model.response.UserResponseModel;

public interface UserPresenter {

    UserResponseModel prepareSuccessView(UserResponseModel user);

    UserResponseModel prepareFailView(String error);

}
