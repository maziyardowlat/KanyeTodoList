package ui;

import model.TodoList;

import javax.swing.*;
import java.awt.*;

// Heavy inspiration was taken from this video
// https://www.youtube.com/watch?v=BQXjF7tw_MQ&t=1369s
public class AppFrame extends JFrame {
    private TitleBar title;
    private ListLayout list1;
    private ButtonPanel btnPanel;

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
    }

}
