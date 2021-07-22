package ui;

import model.Task;
import model.TodoList;

import java.util.Scanner;

public class TodoListApp {
    private Task task1;
    private TodoList list1;
    private Scanner input;

    // EFFECTS: runs the teller application
    public TodoListApp() {
        runList();
    }

    private void runList() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayTask();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("Good Job Today!");

    }

    private void processCommand(String command) {
        if (command.equals("n")) {
            viewTask();
        } else if (command.equals("v")) {
            addTask();
        } else {
            System.out.println("What are you doing Bubsy. Choose another choice");
        }
    }

    private void init() {
        input = new Scanner(System.in);
        task1 = new Task("james", "Science 101", "738", "asdfasdf", "402");
        list1 = new TodoList();

    }

    private void displayTask() {
        System.out.println("\nSelect from:");
        System.out.println("\tn -> View Current Tasks");
        System.out.println("\tv -> Add A New Task");

    }


    private Task showTask() {
        String selection = "";

        while (!selection.equals("s")) {
            System.out.println("Press s to show current task");
            selection = input.next();
            selection = selection.toLowerCase();

        }
        return task1;
    }

    private TodoList modifyTask() {
        String selection = "";

        while (!selection.equals("v")) {
            System.out.println("Press v to add tasks");
            selection = input.next();
            selection = selection.toLowerCase();

        }
        return list1;
    }

    private void viewTask() {
        for (int i = 0; i < list1.getTasks().size(); i++) {
            Task task = list1.getTasks().get(i);
            printTask(task);
        }
    }

    private void addTask() {
        System.out.println("Add A Class Name here:");
        String name = input.next();
        System.out.println("Add A Title here:");
        String title = input.next();
        System.out.println("Add A Due Date here:");
        String dueDate = input.next();
        System.out.println("Add some notes here:");
        String notes = input.next();
        System.out.println("Add A start Date here:");
        String startDate = input.next();
        editor(name, title, dueDate, notes, startDate);
    }

    private void printTask(Task selected) {
        System.out.println(selected.getTitle());
        System.out.println(selected.getDueDate());
    }

    private void editor(String name, String title, String dueDate, String notes, String startDate) {
        list1.addTask(name, title, dueDate, notes, startDate);
    }




}
