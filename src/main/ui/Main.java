package ui;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            new Gui();
            new TodoListApp();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot run the application, could not find the File");
        }
    }
}
