package org.koritsas.vinnslu.main.ws.repos.common;

import org.koritsas.vinnslu.main.models.common.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long> {

    List<Person> findByName(final String name);
    List<Person> findByNameAndSurname(final String name,final String surname);
    Person findByAfm(final Long afm);
}
