package com.example.dataprovider.database.entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import java.time.LocalDateTime;

@MongoEntity(collection="user")
public class UserDataMapper extends PanacheMongoEntity {

    private String id;
    private String name;
    private String password;
    private LocalDateTime creationTime;

    public UserDataMapper() {
    }

    public UserDataMapper(final String name, final String password, final LocalDateTime creationTime) {
        this.name = name;
        this.password = password;
        this.creationTime = creationTime;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(final LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

}
