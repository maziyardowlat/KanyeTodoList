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

    private void init() {
        input = new Scanner(System.in);
        task1 = new Task("asdf", "asdf", "asdf", "asdf", "asdf");

    }

    private void displayTask() {
        System.out.println("\nSelect from:");
        System.out.println("\tn -> Add a new Task");
        System.out.println("\tv -> View Current Tasks");

    }

    private void processCommand(String command) {
        if (command.equals("n")) {
            doNewList();
        } else if (command.equals("v")) {
            doShowTask();
        } else {
            System.out.println("What are you doing Bubsy. Choose another choice");
        }
    }

    private void doNewList(){

    }

    private void doShowTask(){

    }



}
