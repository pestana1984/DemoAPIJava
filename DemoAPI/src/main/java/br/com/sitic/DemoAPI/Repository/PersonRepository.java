package br.com.sitic.DemoAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sitic.DemoAPI.Models.Person;
import java.util.Optional;


public interface PersonRepository extends JpaRepository<Person, Long> {

    public Optional<Person> findByFirstName(String name);

}
