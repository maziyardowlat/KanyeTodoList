package ui;

import model.Task;
import sun.jvm.hotspot.types.JIntField;

import javax.swing.*;
import java.awt.*;

public class TaskUI extends JPanel {

    private JLabel index;
    private JTextField taskName;
    private JTextField taskTitle;
    private JTextField taskDueDate;
    private JTextField taskStartDate;
    private JTextField taskGrades;
    private JButton done;
    private Task task;
    private JList<Task> list;


    private boolean checked;
    //Constructor

    TaskUI() {
        this.setPreferredSize(new Dimension(40,20));
        this.setBackground(Color.white);
        this.setLayout(new BorderLayout());
        checked = false;
        index = new JLabel("");
        index.setPreferredSize(new Dimension(20, 20));
        index.setHorizontalAlignment(JLabel.CENTER);
        this.add(index, BorderLayout.WEST);

        taskName = new JTextField("Your Class Name here");
        taskTitle = new JTextField("Your Task here");
        taskDueDate = new JTextField("Your Task Due Date here");
        taskStartDate = new JTextField("Your Task Start Date here");
        taskGrades = new JTextField("Your Grade here");

        taskName.setBackground(Color.red);

        done = new JButton("done");
        done.setPreferredSize(new Dimension(40, 20));
        this.add(done, BorderLayout.EAST);

    }

    public void taskFunction() {
        String name = taskName.getName();
        String title = taskTitle.getName();
        String dueDate = taskDueDate.getName();
        String grades = taskGrades.getName();
        String startDate = taskStartDate.getName();
        Integer realGrades = Integer.parseInt(grades);
        task = new Task(name, title, dueDate, startDate, realGrades);

        DefaultListModel<Task> listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        listModel.addElement(task);

        this.add(list, BorderLayout.CENTER);


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


}
