package com.example.creditSuisseProject;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.example.creditSuisseProject.model.Role;
import com.example.creditSuisseProject.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {

    @Autowired private RoleRepository repo;

    @Test
    public void testCreateRoles() {
        Role mentor = new Role("Mentor");
        Role admin = new Role("Admin");
        Role mentee = new Role("Mentee");

        repo.saveAll(List.of(mentor, admin, mentee));

        List<Role> listRoles = repo.findAll();

        assertThat(listRoles.size()).isEqualTo(3);
    }

}

