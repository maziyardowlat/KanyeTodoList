package ui;

import model.Task;
import model.TodoList;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

// SOme tips were taken from this video, but no actual foncunality other than the done button
// turning green, and the button display of the buttons has been  inspired
// from this video https://www.youtube.com/watch?v=BQXjF7tw_MQ&t=1369s

public class AppFrame extends JFrame {
    private TitleBar title;
    private ListLayout list1;
    private ButtonPanel btnPanel;
    private TodoList todoList;
    private Task taske;
    private ImageIcon kanye;
    private JLabel label;
    private DefaultListModel<Task> taskyyyy;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private static final String JSON_STORE = "./data/todolist.json";


    private JButton addTask;
    private JButton savedTask;
    private JButton loadTask;
    private JButton showTask;

    //The app frame constructor, and adds several panels
    AppFrame() {

        this.setSize(300, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        title = new TitleBar();
        list1 = new ListLayout();
        btnPanel = new ButtonPanel();
        todoList = new TodoList();
        taskyyyy = new DefaultListModel<>();

        taske = new Task("asdf", "asdf", "asdf", "asdf", "92");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        this.add(title, BorderLayout.NORTH);
        this.add(btnPanel, BorderLayout.SOUTH);
        this.add(list1, BorderLayout.CENTER);

        addTask = btnPanel.getAddTask();
        savedTask = btnPanel.getSaveTask();
        loadTask = btnPanel.getLoadTask();
        showTask = btnPanel.getShowTask();

        addListners();
        addSaver();
        addLoad();

    }

    //MODIFIES: this, TodoList
    //EFFECTS: This button adds a new task to the list, as well functions for the done button
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
                        paintComponent(getGraphics());

                        revalidate();
                    }
                });
                revalidate();
            }
        });
    }

    //MODIFIES: this, TodoList
    //EFFECTS: Saves the TodoList, and closes a picture of Kanye if it is successful
    public void addSaver() {
        savedTask.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                TaskUI task = new TaskUI(todoList, taskyyyy);
                try {
                    jsonWriter.open();
                    jsonWriter.write(todoList);
                    jsonWriter.close();
                    System.out.println("Saved " + taske.getName() + " to " + JSON_STORE);
                    revalidate();
                    removePaint(getGraphics());
                    revalidate();
                } catch (FileNotFoundException f) {
                    System.out.println("Unable to write to file: " + JSON_STORE);
                }
            }
        });
    }

    //MODIFIES: this, TodoList
    //EFFECTS: Loads the wanted task, as well as the show task option
    public void addLoad() {
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
                if (todoList.getTasks().size() > 0) {
                    for (int i = 0; i < todoList.getTasks().size(); i++) {
                        Task task = todoList.getTasks().get(i);
                        TaskUI asdf = new TaskUI(task);
                        that.add(asdf);

                    }
                }
            }
        });
    }

    //MODIFIES: this
    //Adds a picture of Kanye to the todoList
    public void paintComponent(Graphics g) {
        super.paint(g);
        Image backgroundImage;
         // Draw the background image
        try {
            backgroundImage = ImageIO.read(new File("./data/Unknown.jpg"));
            g.drawImage(backgroundImage, 0, 0, this);
        } catch (IOException ioException) {
            System.out.println("Exception!!!!!");
        }
    }

    //MODIFIES: this, AppFrame
    //Remove the Picture of Kanye
    public void removePaint(Graphics g) {
        super.paint(g);
        Image backgroundImage;
        // Draw the background image
        try {
            backgroundImage = ImageIO.read(new File("./data/Unknown.jpg"));
            g.dispose();
        } catch (IOException ioException) {
            System.out.println("Exception!!!!!");
        }
    }

}
