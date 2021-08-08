package ui;

import javax.swing.*;
import java.awt.*;

public class ListLayout extends JPanel {

    //Constructors a List Layout
    ListLayout() {
        GridLayout layout = new GridLayout(10, 1);
        layout.setVgap(5);

        this.setLayout(layout);

    }

}
