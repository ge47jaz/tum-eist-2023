package de.tum.in.ase.eist.controller;

import de.tum.in.ase.eist.model.Person;
import de.tum.in.ase.eist.util.PersonSortingOptions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;

public class PersonController {

    private final WebClient client;
    private List<Person> persons;

    public PersonController() {
        client = WebClient.create("http://localhost:8080");
        persons = new ArrayList<>();
    }

    /**
     * Create a new Person
     * 
     * @param person          the Person to create
     * @param personsConsumer the consumer to accept the list of persons
     * @return the created Person
     */
    public void addPerson(Person person, Consumer<List<Person>> personsConsumer) {
        client.post()
                .uri("/persons")
                .bodyValue(person)
                .retrieve()
                .bodyToMono(Person.class)
                .subscribe(savedPerson -> {
                    persons.add(savedPerson);
                    personsConsumer.accept(persons);
                });
    }

    /**
     * Update an existing Person
     * 
     * @param person          the Person to update
     * @param personsConsumer the consumer to accept the list of persons
     * @return the updated Person
     */
    public void updatePerson(Person person, Consumer<List<Person>> personsConsumer) {
        client.put()
                .uri("/persons/{id}", person.getId())
                .bodyValue(person)
                .retrieve()
                .bodyToMono(Person.class)
                .subscribe(updatedPerson -> {
                    persons.replaceAll(p -> p.getId().equals(updatedPerson.getId()) ? updatedPerson : p);
                    personsConsumer.accept(persons);
                });
    }

    /**
     * Delete an existing Person
     * 
     * @param person          the Person to delete
     * @param personsConsumer the consumer to accept the list of persons
     * @return the deleted Person
     */
    public void deletePerson(Person person, Consumer<List<Person>> personsConsumer) {
        client.delete()
                .uri("/persons/", person.getId())
                .retrieve()
                .toBodilessEntity()
                .onErrorStop()
                .subscribe(v -> {
                    persons.remove(person);
                    personsConsumer.accept(persons);
                });
    }

    /**
     * Get all Persons
     * 
     * @param sortingOptions  the sorting options to sort the persons
     * @param personsConsumer the consumer to accept the list of persons
     * @return the list of Persons
     */
    public void getAllPersons(PersonSortingOptions sortingOptions, Consumer<List<Person>> personsConsumer) {
        client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("persons")
                        .queryParam("sortingOrder", sortingOptions.getSortingOrder())
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Person>>() {
                })
                .onErrorStop()
                .subscribe(newPersons -> {
                    persons.clear();
                    persons.addAll(newPersons);
                    personsConsumer.accept(persons);
                });
    }
}