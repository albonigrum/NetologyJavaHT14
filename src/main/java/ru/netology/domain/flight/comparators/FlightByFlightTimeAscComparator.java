package ru.netology.domain.flight.comparators;

import ru.netology.domain.Flight;

import java.util.Comparator;

public class FlightByFlightTimeAscComparator implements Comparator<Flight> {
    @Override
    public int compare(Flight o1, Flight o2) {
        return o1.getFlightTime() - o2.getFlightTime();
    }
}
