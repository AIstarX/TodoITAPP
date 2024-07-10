package se.lexicon.dao.impl;

import se.lexicon.Person;
import se.lexicon.dao.PersonDao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PersonDaoImpl implements PersonDao {
    private Map<Integer, Person> persons = new HashMap<>();

    @Override
    public Person persist(Person person) {
        persons.put(person.getId(), person);
        return person;
    }

    @Override
    public Person findById(int id) {
        return persons.get(id);
    }

    @Override
    public Person findByEmail(String email) {
        return persons.values().stream()
                .filter(person -> person.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Person> findAll() {
        return new ArrayList<>(persons.values());
    }

    @Override
    public void remove(int id) {
        persons.remove(id);
    }
}
