package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameFormatterTest {

    @Test
    void format_first_and_last_name() {
        // arrange
        String firstName = "Tina";
        String lastName = "Nguyen";
        // act
        NameFormatter.format(firstName, lastName);
        // assert
        assertEquals("Nguyen, Tina", NameFormatter.format(firstName, lastName));
        assertEquals("Nguyen, Kevin", NameFormatter.format("Kevin", "Nguyen"));
        assertEquals("Jones, Kevin", NameFormatter.format("Kevin", "Jones"));
    }

    @Test
    void format_fullName_Only() {
        // arrange
        String fullName = "Tina Nguyen";
        String fullName1 = "John Doe";
        String fullName2 = "Kevin Nguyen";
        // act
        NameFormatter.format(fullName);
        // assert
        assertEquals("Nguyen, Tina", NameFormatter.format(fullName));
        assertEquals("Doe, John",NameFormatter.format(fullName1));
        assertEquals("Nguyen, Kevin",NameFormatter.format(fullName2));
    }

    @Test
    void testFormat1() {
        // arrange
        String prefix = "Dr";
        String firstName = "Mel";
        String middleName = "B";
        String lastName = "Johnson";
        String suffix = "PhD";

        String prefix1 = "Dr";
        String firstName1 = "Tiff";
        String middleName1 = "C";
        String lastName1 = "Jones";
        String suffix1 = "PhD";
        // act
        NameFormatter.format(prefix,firstName,middleName,lastName,suffix);
        // assert
        assertEquals("Johnson, Dr. Mel B, PhD", NameFormatter.format(prefix, firstName, middleName, lastName, suffix));
        assertEquals("Jones, Dr. Tiff C, PhD", NameFormatter.format(prefix1, firstName1, middleName1, lastName1, suffix1));
    }
}