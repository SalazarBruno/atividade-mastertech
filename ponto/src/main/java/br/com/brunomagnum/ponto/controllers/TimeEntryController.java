package br.com.brunomagnum.ponto.controllers;

import br.com.brunomagnum.ponto.models.TimeEntry;
import br.com.brunomagnum.ponto.services.TimeEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/ponto")
public class TimeEntryController {
    @Autowired
    TimeEntryService timeEntryService;

    @PostMapping
    public ResponseEntity<TimeEntry> register(@RequestBody @Valid TimeEntry timeEntry) {
        try {
            return ResponseEntity.status(201).body(timeEntryService.register(timeEntry));
        } catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }
}
