package br.com.brunomagnum.ponto.services;

import br.com.brunomagnum.ponto.enums.EntryType;
import br.com.brunomagnum.ponto.models.TimeEntry;
import br.com.brunomagnum.ponto.models.User;
import br.com.brunomagnum.ponto.repositories.TimeEntryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class TimeEntryServiceTest {

    @Autowired
    TimeEntryService timeEntryService;

    @Autowired
    UserService userService;

    @MockBean
    TimeEntryRepository timeEntryRepository;

    private TimeEntry timeEntry;
    private User user;

    @BeforeEach
    public void setUp(){
        user = new User();
        user.setId(1);
        user.setName("blabla blabla surname");
        user.setEmail("blabla@brunomagnum.com.br");
        user.setCpf("31291504800");
        user.setDate(LocalDate.now());

        timeEntry = new TimeEntry();
        timeEntry.setId(1);
        timeEntry.setUser(user);
        timeEntry.setEntryType(EntryType.SAIDA);
        timeEntry.setPunch(LocalDateTime.now());
    }

    @Test
    public void registerTimeEntryTest(){

        TimeEntry testTimeEntry = new TimeEntry();

        testTimeEntry.setId(1);
        testTimeEntry.setPunch(LocalDateTime.now());
        testTimeEntry.setEntryType(EntryType.SAIDA);
        testTimeEntry.setUser(user);

        //Mockito.when(timeEntryService.)
        Mockito.when(timeEntryRepository.save(Mockito.any(TimeEntry.class))).thenReturn(testTimeEntry);

        Assertions.assertEquals(testTimeEntry, timeEntryService.register(timeEntry));
    }

}
