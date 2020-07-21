package ru.netology.domain.flight.comparators;

import ru.netology.domain.Flight;

import java.util.Comparator;

public class FlightByPriceDescComparator implements Comparator<Flight> {
    @Override
    public int compare(Flight o1, Flight o2) {
        return o2.getPrice() - o1.getPrice();
    }
}
