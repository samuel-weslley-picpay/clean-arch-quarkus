package com.example.dataprovider.database.gateway;

import com.example.core.gateway.UserRegisterDsGateway;
import com.example.core.model.request.UserDsRequestModel;
import com.example.dataprovider.database.entity.UserDataMapper;
import com.example.dataprovider.database.repository.PanacheUserRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JpaUser implements UserRegisterDsGateway {

    final PanacheUserRepository repository;

    public JpaUser(final PanacheUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsByName(final String name) {
        return repository.existsByName(name);
    }

    @Override
    public void save(final UserDsRequestModel requestModel) {
        UserDataMapper accountDataMapper = new UserDataMapper(requestModel.getName(), requestModel.getPassword(), requestModel.getCreationTime());

        repository.persist(accountDataMapper);
    }
}
