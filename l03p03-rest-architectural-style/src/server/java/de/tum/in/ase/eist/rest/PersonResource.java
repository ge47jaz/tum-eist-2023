package de.tum.in.ase.eist.rest;

import de.tum.in.ase.eist.model.Person;
import de.tum.in.ase.eist.service.PersonService;
import de.tum.in.ase.eist.util.PersonSortingOptions;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class PersonResource {

    private final PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    
    /**
     * 
     * @param person the Person to create
     * @return the created Person
     */
    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {

        if (person.getId() != null) {
            // If it has an ID, then it's already in the database
            // and we should not create a new person
            return ResponseEntity.badRequest().build();
        }
        Person savedPerson = personService.savePerson(person);
        return ResponseEntity.status(HttpStatus.OK).body(savedPerson);
    }

    /**
     * Update an existing Person
     * 
     * @param personId the ID of the Person to update
     * @param person   the updated Person
     * @return the updated Person
     */
    @PutMapping("/persons/{personId}")
    public ResponseEntity<Person> updatePerson(@PathVariable UUID personId, @RequestBody Person person) {
        if (!personId.equals(person.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Person updatedPerson = personService.savePerson(person);
        if (updatedPerson == null) {
            // Return a 404 Not Found error if updatedPerson is null
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPerson);
    }

   /**
     * Delete a person.
     *
     * @param personId the person ID
     * @return the response entity
     * @return 204 No Content if the person was deleted successfully
     */
    @DeleteMapping("/persons/{personId}")
    public ResponseEntity<Void> deletePerson(@PathVariable UUID personId) {
        personService.deletePerson(personId);
        return ResponseEntity.noContent().build();
    }

    /**
     * Get a person by ID.
     *
     * @param personId the person ID
     * @return the person
     */
    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.getAllPersons(new PersonSortingOptions());
        return ResponseEntity.ok(persons);
    }
}
