// EXAMPLE TEST (CSCI 630): Reference implementation for Service unit test. Do not delete.
package com.sarasitha.budgettracker.examples;

import com.sarasitha.budgettracker.model.Role;
import com.sarasitha.budgettracker.model.User;
import com.sarasitha.budgettracker.repository.RoleRepository;
import com.sarasitha.budgettracker.repository.UserRepository;
import com.sarasitha.budgettracker.service.UserServiceImpl;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Tag("example")
@ExtendWith(MockitoExtension.class)
public class ExampleUserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testSave_EncodesPasswordAndSavesUser() {
        // Arrange
        User user = new User();
        user.setUsername("bob");
        user.setPassword("plaintext");

        Role role = new Role();
        role.setName("ROLE_USER");

        when(bCryptPasswordEncoder.encode("plaintext")).thenReturn("encodedSecret");
        when(roleRepository.findAll()).thenReturn(List.of(role));

        // Act
        userService.save(user);

        // Assert
        verify(bCryptPasswordEncoder).encode("plaintext");
        verify(userRepository).save(user); // verify repo save called
        assertEquals("encodedSecret", user.getPassword());
        assertEquals(1, user.getRoles().size());
    }
}
