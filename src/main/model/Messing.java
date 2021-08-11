package model;

import com.sun.tools.javac.comp.Todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Messing {
    private Task tasky;
    private Task tasky2;
    private Task task3;
    private TodoList todo1;
    private HashMap<Task, ArrayList<TodoList>> tasks;


    public Messing() {
        Task tasky = new Task("asdf", "asdf", "asdf", "asdf", "93");
        Task tasky2 = new Task("Ulf", "Nick", "Perth", "Tomorrow", "91");
        Task task3 = new Task("Kanye", "Donda", "Esta", "Bibliotecha", "91");
        TodoList todo1 = new TodoList();
        tasks = new HashMap<>();
        tasks.put(tasky, new ArrayList<TodoList>());
        tasks.put(tasky2, new ArrayList<TodoList>());
        ArrayList<TodoList> firstTodo = tasks.get(todo1);

    }



}
