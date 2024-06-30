package se.lexicon;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TodoItemTest {
    private TodoItem todoItem;
    private Person creator;

    @BeforeEach
    public void setUp() {
        creator = new Person(1, "Erik", "Svensson", "erik.svensson@gmail.com");
        todoItem = new TodoItem(1, "Change tires", "Change the car tires before winter", LocalDate.of(2024, 12, 1), creator);
    }

    @Test
    public void testGetId() {
        assertEquals(1, todoItem.getId());
    }

    @Test
    public void testGetTitle() {
        assertEquals("Change tires", todoItem.getTitle());
    }

    @Test
    public void testSetTitle() {
        todoItem.setTitle("Change oil");
        assertEquals("Change oil", todoItem.getTitle());
    }

    @Test
    public void testSetTitleNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            todoItem.setTitle(null);
        });
        assertEquals("Title cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testSetTitleEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            todoItem.setTitle("");
        });
        assertEquals("Title cannot be null or empty", exception.getMessage());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Change the car tires before winter", todoItem.getDescription());
    }

    @Test
    public void testSetDescription() {
        todoItem.setDescription("Change the car oil");
        assertEquals("Change the car oil", todoItem.getDescription());
    }

    @Test
    public void testGetDeadLine() {
        assertEquals(LocalDate.of(2024, 12, 1), todoItem.getDeadLine());
    }

    @Test
    public void testSetDeadLine() {
        todoItem.setDeadLine(LocalDate.of(2024, 11, 30));
        assertEquals(LocalDate.of(2024, 11, 30), todoItem.getDeadLine());
    }

    @Test
    public void testSetDeadLineNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            todoItem.setDeadLine(null);
        });
        assertEquals("Deadline cannot be null", exception.getMessage());
    }

    @Test
    public void testIsOverdue() {
        assertFalse(todoItem.isOverdue());
        todoItem.setDeadLine(LocalDate.now().minusDays(1));
        assertTrue(todoItem.isOverdue());
    }

    @Test
    public void testGetSummary() {
        String expectedSummary = "id: 1, title: Change tires, description: Change the car tires before winter, deadline: 2024-12-01, done: false, creator: id: 1, name: Erik Svensson, email: erik.svensson@gmail.com";
        assertEquals(expectedSummary, todoItem.getSummary());
    }
}
