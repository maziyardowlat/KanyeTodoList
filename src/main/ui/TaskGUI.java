////package ui;
////
////import javax.swing.*;
////import java.awt.*;
////import java.awt.event.ActionEvent;
////import java.awt.event.ActionListener;
////
////public class TaskGUI extends JFrame {
////    private static final int WIDTH = 230;
////    private static final int HEIGHT = 325;
////    private static final int VGAP = 15;
////    private String[] tasks = { "red", "green", "yellow", "purple", "blue" };
////    private TodoListGUI todoListGui;
////    private JPanel taskPanel;
////    private JLabel labelImage;
////
////    public TaskGUI(TodoListGUI todoGui) {
////        todoListGui = todoGui;
////        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
////
////        add(Box.createVerticalStrut(VGAP));
////
////        // Create the selection of light combo box
////        final JComboBox todoListCombo = new JComboBox(tasks);
////        todoListCombo.addActionListener(new ActionListener() {
////            public void actionPerformed(ActionEvent e) {
////                String todoChoice = (String) todoListCombo.getSelectedItem();
////                todoListGui.setVisible(todoChoice);
////            }
////        });
////
////        add(colourCombo);
////
////        add(Box.createVerticalStrut(VGAP));
////
////        taskPanel = new JPanel();
////        taskPanel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
////        add(taskPanel);
////
////        setRedLight();
////    }
////
////    }
//}
