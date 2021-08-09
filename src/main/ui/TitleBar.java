package ui;

import javax.swing.*;
import java.awt.*;

public class TitleBar extends JPanel {

    //Constructor
    TitleBar() {
        this.setPreferredSize(new Dimension(400, 80));

        JLabel titleText = new JLabel("Your Todo List: Welcome");
        titleText.setPreferredSize(new Dimension(200, 80));
        titleText.setFont(new Font("Sans-serif", Font.BOLD, 15));
        titleText.setHorizontalAlignment(JLabel.CENTER);
        this.add(titleText);


    }
}
