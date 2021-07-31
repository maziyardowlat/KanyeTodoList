package model;

import org.json.JSONObject;

// Represents a Task that has a name, a title, notes a Due Date, start Date and if the task if finished or not
public class Task {
    private String name; //Name of the task
    private String title; //Title of the task
    private String dueDate; //The due date of the task
    private String startDate; //The start date of the task
    private Integer grade; //The grade for the specific intended class
    private boolean finished; //if the task is finished or not


    public Task(String name, String title, String dueDate, String startDate, Integer grade) {
        this.name = name;
        this.dueDate = dueDate;
        this.title = title;
        this.startDate = startDate;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getStartDate() {
        return startDate;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTitle() {
        return title;
    }


    public String getDueDate() {
        return dueDate;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("title", title);
        json.put("dueDate", dueDate);
        json.put("startDate", startDate);
        json.put("grade", grade);
        return json;
    }

}
