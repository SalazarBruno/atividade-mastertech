package br.com.brunomagnum.ponto.services;

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
    UserRepository userRepository;

    public TimeEntry register(int idUser) throws Exception {
        Optional<User> user = userRepository.findById(idUser);
        if (!user.isPresent()) {
          throw new Exception("Usuário não encontrado");
        }

        TimeEntry timeEntry = new TimeEntry();
        timeEntry.setUser(user.get());

        List<TimeEntry> entries = timeEntryRepository.findByDate(new Date());
        if (entries.size() != 0 ) {
            if (entries.get(entries.size()-1).getEntryType().equals(EntryType.ENTRADA)) {
                timeEntry.setEntryType(EntryType.SAIDA);
            } else {
                timeEntry.setEntryType(EntryType.ENTRADA);
            }
        } else {
            timeEntry.setEntryType(EntryType.ENTRADA);            
        }
        return timeEntryRepository.save(timeEntry);
    }
}