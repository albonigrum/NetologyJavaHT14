package ru.netology.manager;

import ru.netology.domain.CodeIATA;
import ru.netology.domain.Flight;
import ru.netology.repository.FlightRepository;

import java.util.Arrays;

public class FlightManager {
    FlightRepository repository;

    private FlightManager() {}

    public FlightManager(FlightRepository repository) { this.repository = repository; }

    public void add(Flight flight) { repository.save(flight); }

    public Flight[] findAll(CodeIATA from, CodeIATA to) {
        Flight[] allFlights = repository.findAll();
        Flight[] result = new Flight[0];

        for (Flight flight : allFlights) {
            if (from.equals(flight.getFrom()) && to.equals(flight.getTo())){
                Flight[] tmp = new Flight[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = flight;
                result = tmp;
            }
        }

        Arrays.sort(result);

        return result;
    }
}
