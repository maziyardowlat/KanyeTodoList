package ui;

import javax.swing.*;
import java.awt.*;

public class TitleBar extends JPanel {

    //Constructor
    TitleBar() {
        this.setPreferredSize(new Dimension(400, 500));

        JLabel titleText = new JLabel("Your Todo List");
        titleText.setPreferredSize(new Dimension(200, 90));
        titleText.setFont(new Font("Sans-serif", Font.BOLD, 20));
        titleText.setHorizontalAlignment(JLabel.CENTER);

        this.add(titleText);

    }
}
