package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.CodeIATA;
import ru.netology.domain.Flight;
import ru.netology.repository.FlightRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class FlightManagerTest {
    @Mock
    FlightRepository repository;
    @InjectMocks
    FlightManager manager;

    private final Flight flight1 = new Flight(1, new CodeIATA("SAT"), new CodeIATA("BAT"), 30);
    private final Flight flight2 = new Flight(2, new CodeIATA("SAT"), new CodeIATA("BAT"), 20);
    private final Flight flight3 = new Flight(3, new CodeIATA("SAT"), new CodeIATA("BAT"), 10);
    private final Flight flight4 = new Flight(4, new CodeIATA("BAT"), new CodeIATA("SAT"), 11);
    private final Flight flight5 = new Flight(5, new CodeIATA("SAT"), new CodeIATA("SAT"), 0);
    private final Flight flight6 = new Flight(6, new CodeIATA("BAT"), new CodeIATA("BAT"), 1);

    @BeforeEach
    void setUp() {
        doNothing().when(repository).save(flight1);
        doNothing().when(repository).save(flight2);
        doNothing().when(repository).save(flight3);
        doNothing().when(repository).save(flight4);
        doNothing().when(repository).save(flight5);
        doNothing().when(repository).save(flight6);

        manager.add(flight1);
        manager.add(flight2);
        manager.add(flight3);
        manager.add(flight4);
        manager.add(flight5);
        manager.add(flight6);
    }

    @Test
    void shouldFindAllIfNoElemSatisfyTheRequest() {
        Flight[] returned = {flight1, flight2, flight3, flight4, flight5, flight6};
        doReturn(returned).when(repository).findAll();

        Flight[] actual = manager.findAll(new CodeIATA("SAT"), new CodeIATA("DAT"));
        Flight[] expected = {};

        assertArrayEquals(expected, actual);

    }
    @Test
    void shouldFindAllIfOneElemSatisfyTheRequest() {
        Flight[] returned = {flight1, flight2, flight3, flight4, flight5, flight6};
        doReturn(returned).when(repository).findAll();

        Flight[] actual = manager.findAll(new CodeIATA("BAT"), new CodeIATA("SAT"));
        Flight[] expected = {flight4};

        assertArrayEquals(expected, actual);

    }
    @Test
    void shouldFindAllIfMoreThenOneElemSatisfyTheRequest() {
        Flight[] returned = {flight1, flight2, flight3, flight4, flight5, flight6};
        doReturn(returned).when(repository).findAll();

        Flight[] actual = manager.findAll(new CodeIATA("SAT"), new CodeIATA("BAT"));
        Flight[] expected = {flight3, flight2, flight1};

        assertArrayEquals(expected, actual);

    }

}