package ui;

import model.Task;
import model.TodoList;

import java.util.Locale;
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
            doTask();
        } else if (command.equals("v")) {
            addTask();
        } else {
            System.out.println("What are you doing Bubsy. Choose another choice");
        }
    }

    private void init() {
        input = new Scanner(System.in);
        task1 = new Task("mashoood", "arooowowo", "738", "asdf", "asdf");
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

    private void doTask() {
        Task selected = showTask();
        System.out.println("here is the current tasks on hand:");
        printTask(selected);
    }

    private void addTask() {
        TodoList selected = modifyTask();
        System.out.println("Add A New Task here:");
        editor(selected);
    }

    private void printTask(Task selected) {
        System.out.println(selected.getTitle());
        System.out.println(selected.getDueDate());
    }

    private void editor(TodoList selected) {
        list1.addTask("new", "new", "mew", "mew", "mew");
    }





//    private TodoList selectTask() {
//        String selection = "";
//
//        while (!(selection.equals("a") || selection.equals("b"))) {
//            System.out.println("Press a to add a new task to your list");
//            System.out.println("Press b to view the current titles for your list");
//            selection = input.next();
//            selection = selection.toLowerCase();
//        }
//
//        if (selection.equals("a")) {
//            list1.addTask("asdf", "asdf", "adsf", "asdf", "asdf");
//            return list1;
//        } else {
//            return task1.getTitle().index(0);
//        }
//    }
//
//    //MODIFIES: this
//    //EFFECTS: constructs a deposit transaction
//    private void doNewList() {
//        TodoList lista = selectTask();
//        String selection = "";
//        if (selection.equals("n")) {
//            list1.addTask("asdf", "asdf", "adsf", "asdf", "asdf");
//        } else {
//            System.out.println("Please Press n and enter your specific task");
//        }
//
//    }
//
//    private String doShowTask() {
//        String selection = "";
//        if (selection.equals("v")) {
//            return task1.getTitle();
//        }
//        return selection;
//    }



}
