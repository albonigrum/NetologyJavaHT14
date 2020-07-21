package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Flight implements Comparable<Flight> {
    private long id;
    private int price;
    private CodeIATA from;
    private CodeIATA to;
    //per minutes
    private int flightTime;

    @Override
    public int compareTo(Flight o) {
        return price - o.price;
    }
}


