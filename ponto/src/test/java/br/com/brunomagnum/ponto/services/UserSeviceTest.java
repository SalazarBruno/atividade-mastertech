package br.com.brunomagnum.ponto.services;

import br.com.brunomagnum.ponto.models.User;
import br.com.brunomagnum.ponto.repositories.UserRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootTest
public class UserSeviceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    private User user;
    @BeforeEach
    public void setUp(){
        user = new User();
        user.setName("blabla blabla surname");
        user.setEmail("blabla@brunomagnum.com.br");
        user.setCpf("31291504800");
        user.setDate(LocalDate.now());
    }

    @Test
    public void testfindAllUsers() {

        Mockito.when(userRepository.findAll()).thenReturn(Arrays.asList(user));
        Iterable<User> listOfUsers = userService.findAll();

        Assertions.assertEquals(listOfUsers,Arrays.asList(user));
    }


}
