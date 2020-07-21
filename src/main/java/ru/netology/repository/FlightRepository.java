package ru.netology.repository;

import ru.netology.domain.Flight;

public class FlightRepository {
    private Flight[] items = new Flight[0];

    public Flight[] findAll() {
        return items;
    }

    public void save(Flight item) {
        Flight[] tmp = new Flight[items.length + 1];
        System.arraycopy(items, 0, tmp, 0, items.length);
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Flight findById(int id) {
        for (Flight item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) != null) {
            Flight[] tmp = new Flight[items.length - 1];
            int index = 0;
            for (Flight item : items){
                if (item.getId() != id)
                    tmp[index++] = item;
            }
            items = tmp;
        }
    }

    public void removeAll() {
        items = new Flight[0];
    }
}

