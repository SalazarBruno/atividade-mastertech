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
import java.util.Optional;

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
    public void findAllUsersTest() throws Exception {

        Mockito.when(userRepository.findAll()).thenReturn(Arrays.asList(user));
        Iterable<User> listOfUsers = userService.findAll();

        Assertions.assertEquals(listOfUsers,Arrays.asList(user));
    }


    @Test
    public void findAllUsersWhenNoUsersTest() {

        Mockito.when(userRepository.findAll()).then(objUser -> {
            throw new Exception();
        });


        Assertions.assertThrows(Exception.class, userService::findAll);
    }

    @Test
    public void createUserTest(){
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        Assertions.assertEquals(user,userService.create(user));
    }

    @Test
    public void updateUserTest (){
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
        Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(user));

        Assertions.assertEquals(user,userService.update(1,user));
    }

}
