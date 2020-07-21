package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeIATATest {

    @Test
    void shouldConstructIfCorrectInput() {
        CodeIATA codeIATA = new CodeIATA("SAT");

        assertEquals("SAT", codeIATA.getCode());
    }

    @Test
    void shouldNoConstructIfNoCorrectInput() {
        assertThrows(IllegalArgumentException.class, () -> new CodeIATA("sAT"));

        assertThrows(IllegalArgumentException.class, () -> new CodeIATA("SSSS"));

        assertThrows(IllegalArgumentException.class, () -> new CodeIATA("SS"));

        assertThrows(IllegalArgumentException.class, () -> new CodeIATA(""));

        assertThrows(IllegalArgumentException.class, () -> new CodeIATA("#$1"));
    }
}