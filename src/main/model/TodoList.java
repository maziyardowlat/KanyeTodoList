package model;

import exceptions.BadName;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

public class TodoList implements Writable {
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
    public void addTask(String name, String title, String dueDate, String startDate, String grade) {
        Task task1 = new Task(name, title, dueDate, startDate, grade);
        tasks.add(task1);
    }

    // MODIFIES: this
    // EFFECTS: removes this task from the todolist if the name of the task and the title of the task matches.
    public void removeTask(String name, String title) throws BadName {
        for (int i = 0; i < tasks.size(); i++) {
            if ((tasks.get(i).getName().equals(name)) && (tasks.get(i).getTitle().equals(title))) {
                tasks.remove(tasks.indexOf(tasks.get(i)));
            } else {
                throw new BadName();
            }
        }
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("tasks", tasksToJson());
        return json;
    }

    // EFFECTS: returns the tasks in the todolist as a JSON array
    private JSONArray tasksToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Task t : tasks) {
            jsonArray.put(t.toJson());
        }
        return jsonArray;
    }



}
