package br.com.brunomagnum.ponto.services;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brunomagnum.ponto.enums.EntryType;
import br.com.brunomagnum.ponto.models.TimeEntry;
import br.com.brunomagnum.ponto.models.User;
import br.com.brunomagnum.ponto.repositories.TimeEntryRepository;
import br.com.brunomagnum.ponto.repositories.UserRepository;

@Service
public class TimeEntryService {
    
    @Autowired
    TimeEntryRepository timeEntryRepository;

    @Autowired
    UserService userService;

    public TimeEntry register(TimeEntry timeEntry) throws RuntimeException {
        LocalDateTime punchTime = LocalDateTime.now();

        Optional<User> optionalUser = Optional.ofNullable(userService.findById(timeEntry.getUser().getId()));
        if (optionalUser.isPresent()) {

            timeEntry.setUser(timeEntry.getUser());
            timeEntry.setPunch(punchTime);
            timeEntry.setEntryType(timeEntry.getEntryType());

            return timeEntryRepository.save(timeEntry);
        } else{
            throw new RuntimeException("O usuário informado não existe");
        }
    }

}