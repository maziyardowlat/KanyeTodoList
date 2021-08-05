package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ButtonPanel extends JPanel {
    private JButton addTask;
    private JButton removeTask;

    Border emptyBorder = BorderFactory.createEmptyBorder();

    //Constructor
    ButtonPanel() {
        this.setPreferredSize(new Dimension(400, 60));

        addTask = new JButton("Add A New Task");
        addTask.setBorder(emptyBorder);
        addTask.setFont(new Font("Sans-serif", Font.PLAIN, 20));

        this.add(addTask);

        this.add(Box.createHorizontalStrut(20));

        removeTask = new JButton("Remove A Task");
        removeTask.setBorder(emptyBorder);
        removeTask.setFont(new Font("Sans-serif", Font.PLAIN, 20));

        this.add(removeTask);
    }

    public JButton getAddTask() {
        return addTask;
    }

    public JButton getRemoveTask() {
        return removeTask;
    }
}
