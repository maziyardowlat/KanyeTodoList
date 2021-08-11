package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Messing {
    HashMap<Task, ArrayList<TodoList>> tasks = new HashMap<>();
    TodoList todo1 = new TodoList();
    Task tasky = new Task("asdf", "asdf", "asdf", "asdf", "93");
    Task tasky2 = new Task("Ulf", "Nick", "Perth", "Tomorrow", "91");
    Task task3 = new Task("Kanye", "Donda", "Esta", "Bibliotecha", "91");

    public void messing() {
        tasks.put(tasky, new ArrayList<TodoList>());
        tasks.put(tasky2, new ArrayList<TodoList>());

        ArrayList<TodoList> firstTodo = tasks.get(todo1);

    }



}
