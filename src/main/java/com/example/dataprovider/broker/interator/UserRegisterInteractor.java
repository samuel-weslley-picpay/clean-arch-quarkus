package com.example.dataprovider.broker.interator;

import com.example.core.boundary.UserInputBoundary;
import com.example.core.gateway.UserRegisterDsGateway;
import com.example.core.model.request.UserDsRequestModel;
import com.example.core.model.request.UserRequestModel;
import com.example.core.model.response.UserResponseModel;
import com.example.core.usercase.User;
import com.example.core.usercase.UserFactory;
import com.example.core.validator.UserPresenter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDateTime;

@ApplicationScoped
public class UserRegisterInteractor implements UserInputBoundary {

    @Inject
    UserRegisterDsGateway userDsGateway;
    @Inject
    UserPresenter userPresenter;
    @Inject
    UserFactory userFactory;

    @Override
    public UserResponseModel create(final UserRequestModel requestModel) {
        if (userDsGateway.existsByName(requestModel.getLogin())) {
            return userPresenter.prepareFailView("User already exists.");
        }

        User user = userFactory.create(requestModel.getLogin(), requestModel.getPassword());

        if (!user.passwordIsValid()) {
            return userPresenter.prepareFailView("User password must have more than 5 characters.");
        }

        LocalDateTime now = LocalDateTime.now();

        UserDsRequestModel userDsModel = new UserDsRequestModel(user.getName(), user.getPassword(), now);

        userDsGateway.save(userDsModel);

        UserResponseModel accountResponseModel = new UserResponseModel(user.getName(), now.toString());

        return userPresenter.prepareSuccessView(accountResponseModel);
    }

}
