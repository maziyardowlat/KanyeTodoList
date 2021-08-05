package ui;

import javax.swing.*;
import java.awt.*;

public class ListLayout extends JPanel {

    ListLayout() {
        GridLayout layout = new GridLayout(10, 1);
        layout.setVgap(5);

        this.setLayout(layout);
        this.setBackground(Color.blue);

    }
}
