package model;

public class Task {
    private String name;
    private String title;
    private String notes;
    private String dueDate;
    private String startDate;
    private boolean finished;

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
