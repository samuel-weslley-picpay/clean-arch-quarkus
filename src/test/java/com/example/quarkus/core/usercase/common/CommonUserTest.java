package com.example.quarkus.core.usercase.common;

import com.example.core.usercase.User;
import com.example.core.usercase.common.CommonUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CommonUserTest {

    @Test
    void given123Password_whenPasswordIsNotValid_thenIsFalse() {
        User user = new CommonUser("Baeldung", "123");

        Assertions.assertFalse(user.passwordIsValid());
    }

}
