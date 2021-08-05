//package ui;
//
//import model.Task;
//import model.TodoList;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class TodoListGUI extends JFrame {
//    private static final String STATUS_OK = "System is Ok";
//    private Task task1;
//    private TodoList list;
//    private TaskGUI tasky;
//    private JLabel statusLabel;
//
//    public TodoListGUI() {
//        super("TodoList GUI");
//
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//        statusLabel = new JLabel(STATUS_OK);
//        add(statusLabel, BorderLayout.NORTH);
//
//
//        // Create the TodoList and the GUI for the TodoList
//        createTodoList();
//        JButton advanceButton = new JButton("Add");
//        advanceButton.setActionCommand("add");
//        advanceButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                list.addTask("asdf", "asdf", "asdf", "asdf", 92);
//            }
//        });
//
//        add(advanceButton, BorderLayout.SOUTH);
//
//        pack();
//        setVisible(true);
//
//    }
//
//    public void createTodoList() {
//        list = new TodoList();
//        tasky = new TaskGUI(this);
//        add(tasky, BorderLayout.CENTER);
//    }
//}
