package com.example.loginsystem;

import static org.assertj.core.api.Assertions.assertThat;
import org.apache.el.parser.AstFalse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class UserRepositoryTest {

    @Autowired
    private userRepository repo;
    @Autowired
    private TestEntityManager entityManager;
    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("alexbessedonato03@gmail.com");
        user.setUsername("abd12");
        user.setPassword("password");
        User savedUser = repo.save(user);
        User existUser = entityManager.find(User.class, savedUser.getId());
        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());

    }
}
