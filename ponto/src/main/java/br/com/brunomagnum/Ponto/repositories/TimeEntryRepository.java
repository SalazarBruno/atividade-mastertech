package br.com.brunomagnum.Ponto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.brunomagnum.Ponto.models.TimeEntry;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface TimeEntryRepository extends CrudRepository<TimeEntry, Integer> {
	public Iterable<TimeEntry> findByUserId(String userId);
	public Iterable<TimeEntry> findByDate(Date date);

}