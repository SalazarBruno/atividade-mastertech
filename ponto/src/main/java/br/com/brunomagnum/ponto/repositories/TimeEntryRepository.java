package br.com.brunomagnum.ponto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.brunomagnum.ponto.models.TimeEntry;

import java.util.Date;
import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface TimeEntryRepository extends CrudRepository<TimeEntry, Integer> {
	Iterable<TimeEntry> findByUserId(String userId);
	List<TimeEntry> findByDate(Date date);

}