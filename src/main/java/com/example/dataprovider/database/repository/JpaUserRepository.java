package com.example.dataprovider.database.repository;

import com.example.dataprovider.database.entity.UserDataMapper;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JpaUserRepository implements PanacheMongoRepository <UserDataMapper> {

    public boolean existsByName(String name) {
      return find("name", name).count() > 0;
    }

}
