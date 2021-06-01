package com.example.practice14.services;

import com.example.practice14.repositories.UserRepo;
import com.example.practice14.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepo userRepo;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Captor
    ArgumentCaptor<User> captor;

    @Test
    public void loadUserByUsername(){
        User user1 = new User();
        user1.setUsername("a");
        User user2 = new User();
        user2.setUsername("b");

        Mockito.when(userRepo.findByUsername("a")).thenReturn(user1);
        Mockito.when(userRepo.findByUsername("b")).thenReturn(user2);

        UserService userService = new UserService(userRepo, passwordEncoder);

        Assertions.assertEquals(
                "a",
                userService.loadUserByUsername("a").getUsername()
        );
        Assertions.assertEquals(
                "b",
                userService.loadUserByUsername("b").getUsername()
        );
    }

    @Test
    public void addUser(){
        User user = new User();
        user.setUsername("a");
        UserService userService = new UserService(userRepo, passwordEncoder);
        userService.addUser(user);
        Mockito.verify(userRepo).save(captor.capture());
        User captured = captor.getValue();
        Assertions.assertEquals("a", captured.getUsername());
    }
}
