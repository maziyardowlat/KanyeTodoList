package ui;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        new AppFrame();
        try {
            new TodoListApp();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot run the application, could not find the File");
        }
    }
}
