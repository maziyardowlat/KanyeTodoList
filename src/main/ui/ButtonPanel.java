package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ButtonPanel extends JPanel {
    private JButton addTask;
    private JButton removeTask;
    private JButton saveTask;
    private JButton loadTask;

    Border emptyBorder = BorderFactory.createEmptyBorder();

    //Constructor
    ButtonPanel() {
        this.setPreferredSize(new Dimension(400, 60));
        addTask = new JButton("Add A New Task");
        addTask.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        this.add(addTask);
        this.setBackground(Color.red);

        this.add(Box.createHorizontalStrut(20));

        removeTask = new JButton("Remove A Task");
        removeTask.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        this.add(removeTask);

        this.add(Box.createHorizontalStrut(20));

        saveTask = new JButton("Save this Task");
        saveTask.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        this.add(saveTask);

        this.add(Box.createHorizontalStrut(20));

        loadTask = new JButton("Load the tasks");
        loadTask.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        this.add(loadTask);


    }

    public JButton getAddTask() {
        return addTask;
    }

    public JButton getRemoveTask() {
        return removeTask;
    }

    public JButton getSaveTask() {
        return saveTask;
    }

    public JButton getLoadTask() {
        return loadTask;
    }
}
