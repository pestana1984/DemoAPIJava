package br.com.sitic.DemoAPI.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.sitic.DemoAPI.Business.PersonBusiness;
import br.com.sitic.DemoAPI.Models.Person;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/v1")
public class PersonController {

    @Autowired
    private PersonBusiness personBusiness;    

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons() {
        return personBusiness.findAll();
    }

    @GetMapping("/person/{id}")
    public Optional<Person> getPersonById(@PathVariable Long id) {
        return personBusiness.findPersonById(id);
    }

    @GetMapping("/person/{firstname}")
    public ResponseEntity<Person> getPersonByFirstName(@RequestParam String firstname) {
        //return ResponseEntity.ok().body(personBusiness.findPersonByName(name));
        return ResponseEntity.noContent().build();
    }
     
    @PostMapping("/person")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        if(person.equals(null))
            return ResponseEntity.badRequest().body(person);
        return personBusiness.createPerson(person);
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<Person> deletePersonById (@PathVariable Long id){
        personBusiness.deletePersonById(id);
        return ResponseEntity.ok().build();
    }
    
    
}
