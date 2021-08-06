package ui;

import model.Task;
import model.TodoList;
import sun.jvm.hotspot.types.JIntField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TaskUI extends JPanel {

    private JLabel index;
    private JTextField taskName;
    private JTextField taskTitle;
    private JTextField taskDueDate;
    private JTextField taskStartDate;
    private JTextField taskGrades;
    private JButton done;
    private JButton load;
    private JButton save;
    private TodoList todo;
    private Task task;
    private JList<Task> list;
    private DefaultListModel<Task> taskydefault;

    private boolean checked;
    //Constructor

    TaskUI(TodoList toddie, DefaultListModel<Task> defaultmodel) {

        GridLayout experimentLayout = new GridLayout(0, 1);
        this.setPreferredSize(new Dimension(40,20));
        this.setBackground(Color.white);
        this.setLayout(new GridLayout());
        this.todo = toddie;
        this.taskydefault = defaultmodel;

        checked = false;
        index = new JLabel("");
        index.setPreferredSize(new Dimension(20, 20));
        index.setHorizontalAlignment(JLabel.CENTER);
        this.add(index, BorderLayout.WEST);

        taskName = new JTextField("Your Class Name here");
        taskName.setPreferredSize(new Dimension(20, 20));
        taskName.setHorizontalAlignment(JLabel.CENTER);
        this.add(taskName, BorderLayout.NORTH);

        taskTitle = new JTextField("Your Task here");
        taskName.setPreferredSize(new Dimension(20, 20));
        taskName.setHorizontalAlignment(JLabel.CENTER);
        this.add(taskTitle, BorderLayout.CENTER);

        taskDueDate = new JTextField("Your Task Due Date here");
        taskDueDate.setPreferredSize(new Dimension(20, 20));
        taskDueDate.setHorizontalAlignment(JLabel.CENTER);
        this.add(taskDueDate, BorderLayout.CENTER);

        taskStartDate = new JTextField("Your Task Start Date here");
        taskStartDate.setPreferredSize(new Dimension(20, 20));
        taskStartDate.setHorizontalAlignment(JLabel.CENTER);
        this.add(taskStartDate, BorderLayout.CENTER);

        taskGrades = new JTextField("Your Grade here");
        taskGrades.setPreferredSize(new Dimension(20, 20));
        taskGrades.setHorizontalAlignment(JLabel.CENTER);
        this.add(taskGrades, BorderLayout.SOUTH);


        taskName.setBackground(Color.red);

        done = new JButton("done");
        done.setPreferredSize(new Dimension(40, 20));
        this.add(done, BorderLayout.EAST);


        save = new JButton("save");
        save.setPreferredSize(new Dimension(40, 20));
        this.add(save, BorderLayout.EAST);



        save.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                taskFunction();
            }
        });


    }

    TaskUI(Task task) {
        GridLayout experimentLayout = new GridLayout(0, 1);
        this.setPreferredSize(new Dimension(40,20));
        this.setBackground(Color.black);
        this.setLayout(new GridLayout());

        checked = false;
        index = new JLabel("");
        index.setPreferredSize(new Dimension(20, 20));
        index.setHorizontalAlignment(JLabel.CENTER);
        this.add(index, BorderLayout.WEST);

        taskName = new JTextField(task.getName());
        taskName.setPreferredSize(new Dimension(20, 20));
        taskName.setHorizontalAlignment(JLabel.CENTER);
        this.add(taskName, BorderLayout.NORTH);

        taskTitle = new JTextField(task.getTitle());
        taskName.setPreferredSize(new Dimension(20, 20));
        taskName.setHorizontalAlignment(JLabel.CENTER);
        this.add(taskTitle, BorderLayout.CENTER);

        taskDueDate = new JTextField(task.getDueDate());
        taskDueDate.setPreferredSize(new Dimension(20, 20));
        taskDueDate.setHorizontalAlignment(JLabel.CENTER);
        this.add(taskDueDate, BorderLayout.CENTER);

        taskStartDate = new JTextField(task.getStartDate());
        taskStartDate.setPreferredSize(new Dimension(20, 20));
        taskStartDate.setHorizontalAlignment(JLabel.CENTER);
        this.add(taskStartDate, BorderLayout.CENTER);

        taskGrades = new JTextField(task.getGrade());
        taskGrades.setPreferredSize(new Dimension(20, 20));
        taskGrades.setHorizontalAlignment(JLabel.CENTER);
        this.add(taskGrades, BorderLayout.SOUTH);
    }


    public void taskFunction() {
        String name = taskName.getText();
        String title = taskTitle.getText();
        String dueDate = taskDueDate.getText();
        String grades = taskGrades.getText();
        String startDate = taskStartDate.getText();
        task = new Task(name, title, dueDate, startDate, grades);

        list = new JList<>(taskydefault);
        taskydefault.addElement(task);
        this.add(list, BorderLayout.CENTER);
        todo.addTask(name, title, dueDate, startDate, grades);

        list.setBackground(Color.red);


    }


    public JButton getDone() {
        return done;
    }

    public void changeState() {
        this.setBackground(Color.green);
        taskName.setBackground(Color.green);
        checked = true;
    }

    public TodoList getTodo() {
        return todo;
    }


}
