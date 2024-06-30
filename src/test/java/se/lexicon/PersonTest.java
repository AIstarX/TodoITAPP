package se.lexicon;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {
    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person(1, "Erik", "Svensson", "erik.svensson@gmail.com");
    }

    @Test
    public void testGetId() {
        assertEquals(1, person.getId());
    }

    @Test
    public void testGetFirstName() {
        assertEquals("Erik", person.getFirstName());
    }

    @Test
    public void testSetFirstName() {
        person.setFirstName("Anna");
        assertEquals("Anna", person.getFirstName());
    }

    @Test
    public void testSetFirstNameNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            person.setFirstName(null);
        });
        assertEquals("First name cannot be null", exception.getMessage());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Svensson", person.getLastName());
    }

    @Test
    public void testSetLastName() {
        person.setLastName("Johansson");
        assertEquals("Johansson", person.getLastName());
    }

    @Test
    public void testSetLastNameNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            person.setLastName(null);
        });
        assertEquals("Last name cannot be null", exception.getMessage());
    }

    @Test
    public void testGetEmail() {
        assertEquals("erik.svensson@gmail.com", person.getEmail());
    }

    @Test
    public void testSetEmail() {
        person.setEmail("anna.johansson@gmail.com");
        assertEquals("anna.johansson@gmail.com", person.getEmail());
    }

    @Test
    public void testSetEmailNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            person.setEmail(null);
        });
        assertEquals("Email cannot be null", exception.getMessage());
    }

    @Test
    public void testGetSummary() {
        String expectedSummary = "id: 1, name: Erik Svensson, email: erik.svensson@gmail.com";
        assertEquals(expectedSummary, person.getSummary());
    }
}
