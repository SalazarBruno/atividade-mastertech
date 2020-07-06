package br.com.brunomagnum.ponto.controllers;

import br.com.brunomagnum.ponto.models.User;
import br.com.brunomagnum.ponto.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private UserController userController;

    private User user;
    private User user2;
    @BeforeEach
    public void setUp(){
        user = new User();
        user.setName("blabla blabla surname");
        user.setEmail("blabla@brunomagnum.com.br");
        user.setCpf("31291504800");

        user2 = new User();
        user2.setName("blebleble surname");
        user2.setEmail("bleble@brunomagnum.com.br");
        user2.setCpf("31291504800");
    }

    @Test
    public void testfindAllUsers() throws Exception {
        Mockito.when(userService.findAll()).then(objUser->
        {
            List<User> users = new ArrayList<>();
            users.add(user);
            users.add(user2);
            return users;
        });
        mockMvc.perform(MockMvcRequestBuilders.get("/usuario"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2));
    }

    @Test
    public void testfindAllUsersWhenNoUsers() throws Exception {
        Mockito.when(userService.findAll()).then(objUser->
        {
            throw new RuntimeException();
        });
        mockMvc.perform(MockMvcRequestBuilders.get("/usuario"))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

}

