package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.CodeIATA;
import ru.netology.domain.Flight;

import static org.junit.jupiter.api.Assertions.*;

class FlightRepositoryTest {
    private FlightRepository repository = new FlightRepository();
    private final Flight flight1 = new Flight(1, 60, new CodeIATA("SAT"), new CodeIATA("BAT"), 30);
    private final Flight flight2 = new Flight(2, 50, new CodeIATA("SAT"), new CodeIATA("BAT"), 20);
    private final Flight flight3 = new Flight(3, 40, new CodeIATA("SAT"), new CodeIATA("BAT"), 10);
    private final Flight flight4 = new Flight(4, 30, new CodeIATA("BAT"), new CodeIATA("SAT"), 11);
    private final Flight flight5 = new Flight(5, 20, new CodeIATA("SAT"), new CodeIATA("SAT"), 0);
    private final Flight flight6 = new Flight(6, 10, new CodeIATA("BAT"), new CodeIATA("BAT"), 1);


    @BeforeEach
    void setUp() {
        repository.save(flight1);
        repository.save(flight2);
        repository.save(flight3);
        repository.save(flight4);
        repository.save(flight5);
        repository.save(flight6);
    }

    @Test
    void shouldFindAll() {
        Flight[] actual = repository.findAll();
        Flight[] expected = {flight1, flight2, flight3, flight4, flight5, flight6};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByIdIfInRepository() {
        int idToFind = 2;

        Flight actual = repository.findById(idToFind);

        assertEquals(flight2, actual);
    }

    @Test
    void shouldFindByIdIfNoInRepository() {
        int idToFind = 7;

        Flight actual = repository.findById(idToFind);

        assertNull(actual);
    }


    @Test
    void shouldRemoveByIdIfInRepository() {
        int idToRemove = 2;

        repository.removeById(idToRemove);

        Flight[] actual = repository.findAll();
        Flight[] expected = {flight1, flight3, flight4, flight5, flight6};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdIfNoInRepository() {
        int idToRemove = 7;

        repository.removeById(idToRemove);

        Flight[] actual = repository.findAll();
        Flight[] expected = {flight1, flight2, flight3, flight4, flight5, flight6};

        assertArrayEquals(expected, actual);
    }



    @Test
    void shouldRemoveAll() {
        repository.removeAll();

        Flight[] actual = repository.findAll();
        Flight[] expected = {};

        assertArrayEquals(expected, actual);
    }
}