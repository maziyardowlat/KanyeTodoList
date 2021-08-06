package ui;

import model.TodoList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Heavy inspiration was taken from this video
// https://www.youtube.com/watch?v=BQXjF7tw_MQ&t=1369s
public class AppFrame extends JFrame {
    private TitleBar title;
    private ListLayout list1;
    private ButtonPanel btnPanel;
    private TodoList todoList;
    private TodoListApp listy;

    private JButton addTask;
    private JButton removeTask;
    private JButton savedTask;
    private JButton loadTask;

    AppFrame() {

        this.setSize(400, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        title = new TitleBar();
        list1 = new ListLayout();
        btnPanel = new ButtonPanel();
        this.add(title, BorderLayout.NORTH);
        this.add(btnPanel, BorderLayout.SOUTH);
        this.add(list1, BorderLayout.CENTER);

        addTask = btnPanel.getAddTask();
        removeTask = btnPanel.getRemoveTask();
        savedTask = btnPanel.getSaveTask();
        loadTask = btnPanel.getLoadTask();


        addListners();

    }

    public void addListners() {
        addTask.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                TaskUI task = new TaskUI();
                list1.add(task);

                task.getDone().addMouseListener(new MouseAdapter() {

                    @Override
                    public void mousePressed(MouseEvent e) {
                        task.changeState();
                        revalidate();
                    }
                });
                revalidate();
            }
        });

        removeTask.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                TaskUI task = new TaskUI();
                list1.remove(task);
                revalidate();
            }
        });

        savedTask.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mousePressed(MouseEvent e) {
                TaskUI task = new TaskUI();
                TodoListApp listy = new TodoListApp();
                listy.save
            }
        });
    }

}
