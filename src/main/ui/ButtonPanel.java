package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ButtonPanel extends JPanel {
    private JButton addTask;
    private JButton saveTask;
    private JButton loadTask;
    private JButton showTask;

    Border emptyBorder = BorderFactory.createEmptyBorder();

    //Constructor for the Button Panel
    ButtonPanel() {
        this.setPreferredSize(new Dimension(400, 60));
        addTask = new JButton("Add A New Task");
        addTask.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        this.add(addTask);
        this.setBackground(Color.red);

        this.add(Box.createHorizontalStrut(20));

        saveTask = new JButton("Save this Task (Kanye will dissapear if this is successful)");
        saveTask.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        this.add(saveTask);

        this.add(Box.createHorizontalStrut(20));

        loadTask = new JButton("Load the tasks");
        loadTask.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        this.add(loadTask);

        showTask = new JButton("Show Task");
        showTask.setFont(new Font("Sans-serif", Font.PLAIN, 20));
        this.add(showTask);

    }

    public JButton getAddTask() {
        return addTask;
    }


    public JButton getSaveTask() {
        return saveTask;
    }

    public JButton getLoadTask() {
        return loadTask;
    }

    public JButton getShowTask() {
        return showTask;
    }
}
