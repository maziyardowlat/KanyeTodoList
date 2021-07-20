package model;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private List<Task> tasks;
    private Task task1;

    public TodoList() {
        tasks = new ArrayList<>();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task t) {
        tasks.add(t);
    }

    public void removeTask(Task t) {
        tasks.remove(t);
    }
}
