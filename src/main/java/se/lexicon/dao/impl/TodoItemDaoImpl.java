package se.lexicon.dao.impl;

import se.lexicon.TodoItem;
import se.lexicon.dao.TodoItemDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TodoItemDaoImpl implements TodoItemDao {
    private Map<Integer, TodoItem> todoItems = new HashMap<>();

    @Override
    public TodoItem persist(TodoItem todoItem) {
        todoItems.put(todoItem.getId(), todoItem);
        return todoItem;
    }

    @Override
    public TodoItem findById(int id) {
        return todoItems.get(id);
    }

    @Override
    public Collection<TodoItem> findAll() {
        return new ArrayList<>(todoItems.values());
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {
        return todoItems.values().stream()
                .filter(todoItem -> todoItem.isDone() == done)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        return todoItems.values().stream()
                .filter(todoItem -> todoItem.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        return todoItems.values().stream()
                .filter(todoItem -> todoItem.getCreator().getId() == personId)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate date) {
        return todoItems.values().stream()
                .filter(todoItem -> todoItem.getDeadLine().isBefore(date))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate date) {
        return todoItems.values().stream()
                .filter(todoItem -> todoItem.getDeadLine().isAfter(date))
                .collect(Collectors.toList());
    }

    @Override
    public void remove(int id) {
        todoItems.remove(id);
    }
}
