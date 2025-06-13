package br.com.sitic.DemoAPI.Business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import br.com.sitic.DemoAPI.Models.Person;
import br.com.sitic.DemoAPI.Repository.PersonRepository;

@Controller
public class PersonBusiness {
    @Autowired
    private PersonRepository personRepository;

    public ResponseEntity<List<Person>> findAll(){
        if(personRepository.findAll().isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(personRepository.findAll());
    }

    public ResponseEntity<Person> createPerson(Person person){
        return ResponseEntity.ok().body(personRepository.save(person));
    }

    public Optional<Person> findPersonById(Long id){
        return personRepository.findById(id);
    }

    public Optional<Person> findPersonByFirstName(String name){
        return personRepository.findByFirstName(name);
    }

    public ResponseEntity<Person> deletePersonById(Long id){
        personRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
