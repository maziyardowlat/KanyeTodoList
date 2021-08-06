package ui;

import javax.swing.*;
import java.awt.*;

public class TitleBar extends JPanel {

    //Constructor
    TitleBar() {
        this.setPreferredSize(new Dimension(400, 80));

        JLabel titleText = new JLabel("Your Todo List: To remove a task, "
                +
                "enter the exact same fields as the task you are wanting to remove, then click remove.");
        titleText.setPreferredSize(new Dimension(200, 80));
        titleText.setFont(new Font("Sans-serif", Font.BOLD, 20));
        titleText.setHorizontalAlignment(JLabel.CENTER);
        this.add(titleText);


    }
}
