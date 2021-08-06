package ui;

import com.sun.tools.javac.comp.Todo;
import model.Task;
import model.TodoList;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

// Heavy inspiration was taken from this video
// https://www.youtube.com/watch?v=BQXjF7tw_MQ&t=1369s
public class AppFrame extends JFrame {
    private TitleBar title;
    private ListLayout list1;
    private ButtonPanel btnPanel;
    private TodoList todoList;
    private TodoListApp listy;
    private Task taske;
    private ImageIcon kanye;
    JLabel label;
    private DefaultListModel<Task> taskyyyy;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private static final String JSON_STORE = "./data/todolist.json";


    private JButton addTask;
    private JButton removeTask;
    private JButton savedTask;
    private JButton loadTask;
    private JButton showTask;

    AppFrame() {

        this.setSize(400, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


        title = new TitleBar();
        list1 = new ListLayout();
        btnPanel = new ButtonPanel();
        todoList = new TodoList();
        taskyyyy = new DefaultListModel<>();
        kanye = new ImageIcon("./data/Kanye.jpg");

//        label = new JLabel();
//        label.addMouseListener(this);
//
//        label.setIcon(kanye);
//        this.add(label);


        taske = new Task("asdf", "asdf", "asdf", "asdf", "92");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        this.add(title, BorderLayout.NORTH);
        this.add(btnPanel, BorderLayout.SOUTH);
        this.add(list1, BorderLayout.CENTER);

        addTask = btnPanel.getAddTask();
        removeTask = btnPanel.getRemoveTask();
        savedTask = btnPanel.getSaveTask();
        loadTask = btnPanel.getLoadTask();
        showTask = btnPanel.getShowTask();


        addListners();

    }

    public void addListners() {
        addTask.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                TaskUI task = new TaskUI(todoList, taskyyyy);
                list1.add(task);

                task.getDone().addMouseListener(new MouseAdapter() {

                    @Override
                    public void mousePressed(MouseEvent e) {
                        task.changeState();
//                        label.setIcon(kanye);

                        revalidate();
                    }
                });
                revalidate();
            }
        });


        removeTask.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                TaskUI task = new TaskUI(todoList, taskyyyy);
                list1.remove(task);
                revalidate();
            }
        });

        savedTask.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                TaskUI task = new TaskUI(todoList, taskyyyy);
                    try {
                        jsonWriter.open();
                        jsonWriter.write(todoList);
                        jsonWriter.close();
                        System.out.println("Saved " + taske.getName() + " to " + JSON_STORE);
                    } catch (FileNotFoundException f) {
                        System.out.println("Unable to write to file: " + JSON_STORE);
                    }
                }
            });

        loadTask.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                    try {
                        todoList = jsonReader.read();
                    } catch (IOException f) {
                        System.out.println("Unable to read from file: " + JSON_STORE);
                    }
                }
            });

        AppFrame that = this;
        showTask.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("asdfasdfasdf");
                if (todoList.getTasks().size() > 0) {
                    System.out.println("HELOOOOOOOO");
                    for (int i = 0; i < todoList.getTasks().size(); i++) {
                        System.out.println("KANYE");
                        Task taskyeye = todoList.getTasks().get(i);
                        TaskUI asdf = new TaskUI(taskyeye);
                        that.add(asdf);
                    }
//                } else {
//                    printSad(task1);
                }
            }
        });

    }
}
