package ru.netology.domain;

import lombok.Data;

@Data
public class CodeIATA {
    public static final int NUMBER_CHARACTER = 3;
    private String code;

    public void setCode(String code) {
        if (code.length() != NUMBER_CHARACTER)
            throw new IllegalArgumentException(
                    "Length of IATA code must be " + NUMBER_CHARACTER +
                            ", there is not " + NUMBER_CHARACTER + ": "  + code);
        for (int i = 0; i < NUMBER_CHARACTER; ++i) {
            if (!Character.isLetter(code.charAt(i)) || !Character.isUpperCase(code.charAt(i)))
                throw new IllegalArgumentException("Input code: " + code +  " - not all characters from A to Z");
        }
        this.code = code;
    }

    public CodeIATA(String code) {
        setCode(code);
    }
}
