package se.lexicon.dao.impl;

import se.lexicon.TodoItemTask;
import se.lexicon.dao.TodoItemTaskDao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TodoItemTaskDaoImpl implements TodoItemTaskDao {
    private Map<Integer, TodoItemTask> todoItemTasks = new HashMap<>();

    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {
        todoItemTasks.put(todoItemTask.getId(), todoItemTask);
        return todoItemTask;
    }

    @Override
    public TodoItemTask findById(int id) {
        return todoItemTasks.get(id);
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return new ArrayList<>(todoItemTasks.values());
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean assigned) {
        return todoItemTasks.values().stream()
                .filter(todoItemTask -> todoItemTask.isAssigned() == assigned)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {
        return todoItemTasks.values().stream()
                .filter(todoItemTask -> todoItemTask.getAssignee().getId() == personId)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(int id) {
        todoItemTasks.remove(id);
    }
}
