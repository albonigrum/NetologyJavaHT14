package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Flight implements Comparable<Flight> {
    private long id;
    private CodeIATA from;
    private CodeIATA to;
    //per minutes
    private int flightTime;

    @Override
    public int compareTo(Flight o) {
        return flightTime - o.flightTime;
    }
}
