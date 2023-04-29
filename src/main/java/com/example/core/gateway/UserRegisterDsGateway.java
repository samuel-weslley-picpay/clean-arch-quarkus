package com.example.core.gateway;

import com.example.core.model.request.UserDsRequestModel;

public interface UserRegisterDsGateway {

    boolean existsByName(String name);

    void save(UserDsRequestModel requestModel);

}
