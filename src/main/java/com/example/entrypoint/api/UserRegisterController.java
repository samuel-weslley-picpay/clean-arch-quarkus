package com.example.entrypoint.api;

import com.example.core.boundary.UserInputBoundary;
import com.example.core.model.request.UserRequestModel;
import com.example.core.model.response.UserResponseModel;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/user")
@Produces("application/json")
@Consumes("application/json")
public class UserRegisterController {

    @Inject
    UserInputBoundary userInput;

    @POST
    public UserResponseModel create(UserRequestModel requestModel) {
        return userInput.create(requestModel);
    }

}