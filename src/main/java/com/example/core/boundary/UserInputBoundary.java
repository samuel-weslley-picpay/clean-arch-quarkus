package com.example.core.boundary;

import com.example.core.model.request.UserRequestModel;
import com.example.core.model.response.UserResponseModel;


public interface UserInputBoundary {

    UserResponseModel create(UserRequestModel requestModel);

}
