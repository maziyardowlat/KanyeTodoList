package model;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private ArrayList<Task> tasks;
    private Task task1;

    //Constructor, makes a new TodoList
    public TodoList() {
        tasks = new ArrayList<>();
    }

    //EFFECTS: returns the todolist items
    public List<Task> getTasks() {
        return tasks;
    }

    //MODIFIES: this
    //EFFECTS: adds a new task to the todolist
    public void addTask(Task t) {
        tasks.add(t);
    }

    public void removeTask(Task t) {
        tasks.remove(t);
    }
}
