package br.com.brunomagnum.ponto.controllers;

import br.com.brunomagnum.ponto.enums.EntryType;
import br.com.brunomagnum.ponto.models.TimeEntry;
import br.com.brunomagnum.ponto.models.User;
import br.com.brunomagnum.ponto.services.TimeEntryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.LocalDateTime;

@WebMvcTest(TimeEntryController.class)
public class TimeEntryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TimeEntryService timeEntryService;

    private TimeEntry timeEntry;
    private User user;

    @BeforeEach
    public void setUp(){
        user = new User();
        user.setId(1);
        user.setName("blabla blabla surname");
        user.setEmail("blabla@brunomagnum.com.br");
        user.setCpf("31291504800");

        timeEntry = new TimeEntry();
        timeEntry.setId(1);
        timeEntry.setEntryType(EntryType.ENTRADA);
        timeEntry.setPunch(LocalDateTime.now());
        timeEntry.setUser(user);

    }

    @Test
    public void registerTest() throws Exception {
        Mockito.when(timeEntryService.register(Mockito.any(TimeEntry.class))).then(objTimeEntry ->{
           // timeEntry.setId(1);
            timeEntry.setPunch(LocalDateTime.now());
            timeEntry.setEntryType(EntryType.ENTRADA);
            timeEntry.setPunch(LocalDateTime.now());

            user.setId(1);
            user.setName("blabla blabla surname");
            user.setEmail("blabla@brunomagnum.com.br");
            user.setCpf("31291504800");
            user.setDate(LocalDate.now());

            timeEntry.setUser(user);

            return timeEntry;
        });

        ObjectMapper mapper = new ObjectMapper();
        String timeEntryJson = mapper.writeValueAsString(timeEntry);

        mockMvc.perform(MockMvcRequestBuilders.post("/ponto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(timeEntryJson))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.equalTo(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.date", CoreMatchers.equalTo((LocalDate.now().toString()))));

    }
}
