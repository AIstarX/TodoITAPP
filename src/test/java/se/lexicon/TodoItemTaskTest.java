package se.lexicon;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TodoItemTaskTest {
    private TodoItemTask task;
    private TodoItem todoItem;
    private Person assignee;

    @BeforeEach
    public void setUp() {
        assignee = new Person(1, "Erik", "Svensson", "erik.svensson@gmail.com");
        todoItem = new TodoItem(1, "Change tires", "Change the car tires before winter", LocalDate.of(2024, 12, 1), assignee);
        task = new TodoItemTask(1, todoItem, assignee);
    }

    @Test
    public void testGetId() {
        assertEquals(1, task.getId());
    }

    @Test
    public void testIsAssigned() {
        assertTrue(task.isAssigned());
    }

    @Test
    public void testSetAssignee() {
        Person newAssignee = new Person(2, "Anna", "Svensson", "anna.svensson@gmail.com");
        task.setAssignee(newAssignee);
        assertEquals(newAssignee, task.getAssignee());
        assertTrue(task.isAssigned());
    }

    @Test
    public void testSetAssigneeNull() {
        task.setAssignee(null);
        assertNull(task.getAssignee());
        assertFalse(task.isAssigned());
    }

    @Test
    public void testGetTodoItem() {
        assertEquals(todoItem, task.getTodoItem());
    }

    @Test
    public void testSetTodoItem() {
        TodoItem newTodoItem = new TodoItem(2, "Change oil", "Change the car oil", LocalDate.of(2024, 11, 30), assignee);
        task.setTodoItem(newTodoItem);
        assertEquals(newTodoItem, task.getTodoItem());
    }

    @Test
    public void testSetTodoItemNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            task.setTodoItem(null);
        });
        assertEquals("TodoItem cannot be null", exception.getMessage());
    }

    @Test
    public void testGetSummary() {
        String expectedSummary = "id: 1, assigned: true, todoItem: id: 1, title: Change tires, description: Change the car tires before winter, deadline: 2024-12-01, done: false, creator: id: 1, name: Erik Svensson, email: erik.svensson@gmail.com, assignee: id: 1, name: Erik Svensson, email: erik.svensson@gmail.com";
        assertEquals(expectedSummary, task.getSummary());
    }
}
