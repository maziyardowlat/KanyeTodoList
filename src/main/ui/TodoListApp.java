package ui;

import model.Task;
import model.TodoList;

import java.util.Scanner;

//Several inspirations were taken from the TellerApp that was provided for this stage of the project, such as the
// methods for runList, displayTask, init and process command to an extent.

//TodoList application
public class TodoListApp {
    private Task task1;
    private TodoList list1;
    private Scanner input;

    // EFFECTS: runs the teller application
    public TodoListApp() {
        runList();
    }

    //MODIFIES: this
    //EFFECTS: processes the input from the user
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

    //MODIFIES: this
    //EFFECTS: processes the user command
    private void processCommand(String command) {
        if (command.equals("v")) {
            viewTask();
        } else if (command.equals("a")) {
            addTask();
        } else if (command.equals("r")) {
            removeTask();
        } else {
            System.out.println("What are you doing Mate. Choose another choice");
        }
    }

    //MODIFIES: this
    //EFFECTS: initializes the todoList
    private void init() {
        input = new Scanner(System.in);
        task1 = new Task("james", "Science 101", "738", "asdfasdf", "402");
        list1 = new TodoList();

    }

    // EFFECTS: displays the list of options that are available to the user.
    private void displayTask() {
        System.out.println("\nSelect from:");
        System.out.println("\tv -> View Current Tasks");
        System.out.println("\ta -> Add A New Task");
        System.out.println("\tr -> Remove A Current Task");
        System.out.println("\tq -> Quit the TodoList");

    }

    //MODIFIES: this
    //EFFECTS: displays the tasks that are added, or displays a message saying to add more tasks.
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

    //MODIFIES: this
    //EFFECTS: brings up a menu where the user inputs their tasks, and then proceeds to add this task to the list
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

    //MODIFIES: this
    //EFFECTS: brings up a menu where the user can input the fields for the task they want to remove, and removes it
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

    //MODIFIES: this
    //EFFECTS: adds a task to the list.
    private void editor(String name, String title, String dueDate, String notes, String startDate) {
        list1.addTask(name, title, dueDate, notes, startDate);
    }

    //MODIFIES: this
    //EFFECTS: checks to see the size of the list, and if the list size is bigger than 0, it removes the task.
    //Otherwise is returns a message
    private void remover(String name, String title, String dueDate, String notes, String startDate) {
        if (list1.getTasks().size() > 0) {
            list1.removeTask(name, title, dueDate, notes, startDate);
        } else {
            dumbo(task1);
        }
    }

    //EFFECTS: combines a few of the notes for a task and prints it out
    private void printTask(Task selected) {
        String s = selected.getTitle() + " Due On: " + selected.getDueDate() + " For: " + selected.getName();
        System.out.println(s);
    }

    //EFFECTS: prints off the message that nothing is added yet to the list
    private void printSad(Task selected) {
        String s = "Sorry, nothing added yet. Please add a task to your list";
        System.out.println(s);
    }

    //EFFECTS: prints off the message that you cannot perform the following task at this moment
    private void dumbo(Task selected) {
        String s = "Sorry, you cannot do this. Please Choose another Option.";
        System.out.println(s);
    }

}
