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
        } else if (command.equals("r")) {
            removeTask();
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
        System.out.println("\tr -> Remove A Current Task");

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
        if (list1.getTasks().size() > 0) {
            for (int i = 0; i < list1.getTasks().size(); i++) {
                Task task = list1.getTasks().get(i);
                printTask(task);
            }
        } else {
            printSad(task1);
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

    private void removeTask() {
        System.out.println("Remove A Class Name here:");
        String name = input.next();
        System.out.println("remove A Title here:");
        String title = input.next();
        System.out.println("Remove A Due Date here:");
        String dueDate = input.next();
        System.out.println("Remove the Notes");
        String notes = input.next();
        System.out.println("Remove the start Date");
        String startDate = input.next();
        remover(name, title, dueDate, notes, startDate);
    }


    private void editor(String name, String title, String dueDate, String notes, String startDate) {
        list1.addTask(name, title, dueDate, notes, startDate);
    }

    private void remover(String name, String title, String dueDate, String notes, String startDate) {
        if (list1.getTasks().size() > 0) {
            list1.removeTask(name, title, dueDate, notes, startDate);
        }
        printSad(task1);
    }

    private void printTask(Task selected) {
        String s = selected.getTitle() + " Due On:" + selected.getDueDate();
        System.out.println(s);
    }

    private void printSad(Task selected) {
        String s = "Sorry, nothing added yet";
        System.out.println(s);
    }


}
