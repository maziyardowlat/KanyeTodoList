package model;

// Represents a Task that has a name, a title, notes a Due Date, start Date and if the task if finished or not
public class Task {
    private String name; //Name of the task
    private String title; //Title of the task
    private String notes; //Notes that are left on the task
    private String dueDate; //The due date of the task
    private String startDate; //The start date of the task
    private boolean finished; //if teh task is finished or not

    public Task(String name, String title, String dueDate, String notes, String startDate) {
        this.name = name;
        this.dueDate = dueDate;
        this.title = title;
        this.notes = notes;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTitle() {
        return title;
    }

    public String getNotes() {
        return notes;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
