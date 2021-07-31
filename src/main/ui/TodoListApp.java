package ui;

import model.Task;
import model.TodoList;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//Several inspirations were taken from the TellerApp that was provided for this stage of the project, such as the
// methods for runList, displayTask, init and process command to an extent:
// https://github.students.cs.ubc.ca/CPSC210/TellerApp.git

//Several inspirations were also taken from the JsonSerializedDemo for this step of the project, such as the main
// implementation of the JsonReader, JsonWriter and the implementation of them via the console log:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

//TodoList application
public class TodoListApp {
    private static final String JSON_STORE = "./data/todolist.json";
    private Task task1;
    private TodoList list1;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    //MODIFIES: this
    //EFFECTS: initializes the todoList
    private void init() {
        input = new Scanner(System.in);
        task1 = new Task("james", "Science 101", "738", "asdfasdf", 402);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        list1 = new TodoList();
    }


    // EFFECTS: runs the teller application
    public TodoListApp() throws FileNotFoundException {
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
        } else if (command.equals("s")) {
            saveTodoList();
        } else if (command.equals("l")) {
            loadTodoList();
        } else {
            System.out.println("What are you doing Mate. Choose another choice");
        }
    }

    // EFFECTS: displays the list of options that are available to the user.
    private void displayTask() {
        System.out.println("\nSelect from:");
        System.out.println("\tv -> View Current Tasks");
        System.out.println("\ta -> Add A New Task");
        System.out.println("\tr -> Remove A Current Task");
        System.out.println("\ts -> Save the current TodoList");
        System.out.println("\tl -> Load the current TodoList");
        System.out.println("\tq -> Quit the TodoList");

    }

    //MODIFIES: this
    //EFFECTS: displays the tasks that are added, or displays a message saying to add more tasks.
    private void viewTask() {
        if (list1.getTasks().size() > 0) {
            for (int i = 0; i < list1.getTasks().size(); i++) {
                Task task = list1.getTasks().get(i);
                printTask(task);
                printGrade(task);
            }
        } else {
            printSad(task1);
        }
    }

    // EFFECTS: saves the workroom to file
    private void saveTodoList() {
        try {
            jsonWriter.open();
            jsonWriter.write(list1);
            jsonWriter.close();
            System.out.println("Saved " + task1.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS; loads todoList from file
    private void loadTodoList() {
        try {
            list1 = jsonReader.read();
            System.out.println("Loaded " + task1.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
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
        System.out.println("Add A start Date here:");
        String startDate = input.next();
        System.out.println("Add A Grade here:");
        while (!input.hasNextInt()) {
            input.nextLine();
            input.nextLine();
            System.out.println("Please Enter an Integer Instead");
        }
        Integer grade = input.nextInt();
        editor(name, title, dueDate, startDate, grade);
    }

    //MODIFIES: this
    //EFFECTS: brings up a menu where the user can input the fields for the task they want to remove, and removes it
    private void removeTask() {
        System.out.println("Remove A Class Name here:");
        String name = input.next();
        System.out.println("remove A Title here:");
        String title = input.next();
        remover(name, title);
    }

    //MODIFIES: this
    //EFFECTS: adds a task to the list.
    private void editor(String name, String title, String dueDate, String startDate, Integer grade) {
        list1.addTask(name, title, dueDate, startDate, grade);
    }

    //MODIFIES: this
    //EFFECTS: checks to see the size of the list, and if the list size is bigger than 0, it removes the task.
    //Otherwise is returns a message
    private void remover(String name, String title) {
        if (list1.getTasks().size() > 0) {
            list1.removeTask(name, title);
        } else {
            dumbo(task1);
        }
    }

    //EFFECTS: combines a few of the notes for a task and prints it out
    private void printTask(Task selected) {
        String s = selected.getTitle() + " Is Due: " + selected.getDueDate() + " For: " + selected.getName();
        System.out.println(s);
    }

    //EFFECTS: prints off the message that nothing is added yet to the list
    private void printSad(Task selected) {
        String s = "Sorry, nothing added yet. Please add a task to your list";
        System.out.println(s);
    }

    //EFFECTS: prints our current grade.
    private void printGrade(Task selected) {
        String s = "Your current Grade for " + selected.getName() + " Class " + " is " + selected.getGrade();
        System.out.println(s);
    }

    //EFFECTS: prints off the message that you cannot perform the following task at this moment
    private void dumbo(Task selected) {
        String s = "Sorry, you cannot do this. Either you have tried to remove the Wrong Task, or there are no tasks.";
        System.out.println(s);
    }

}
