package model;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private ArrayList<Task> tasks;

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
    public void addTask(String name, String title, String dueDate, String notes, String startDate) {
        Task task1 = new Task(name, title, dueDate, notes, startDate);
        tasks.add(task1);
    }

    //MODIFIES: this
    //EFFECTS: removes this task from the todolist
    public void removeTask(String name, String title, String dueDate, String notes, String startDate) {
        tasks.remove(tasks.size() - 1);
    }
}
