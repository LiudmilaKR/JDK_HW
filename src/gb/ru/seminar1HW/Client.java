package gb.ru.seminar1HW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client extends JFrame {
    private static final int WIN_WIDTH = 450;
    private static final int WIN_HIGH = 450;
    private static final int WIN_X = 800;
    private static final int WIN_Y = 200;
    private static final String TITLE = "Client";
    private static final String SEND_MESSAGE = "send";

    private JButton btnSend, btnLogin;
    private JTextField textField, ipField, portField, nameField, emptyField;
    JPasswordField passwordField;
    private JPanel bottomPanel, topPanel;
    private JTextArea mainField;
    private boolean isTextForSendToServerExist = false;

    Client() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WIN_X, WIN_Y);
        setSize(WIN_WIDTH, WIN_HIGH);
        setTitle(TITLE);
        setResizable(false);

        add(setMainField());
        add(setBottomPanel(), BorderLayout.SOUTH);
        add(setTopPanel(), BorderLayout.NORTH);


        setVisible(true);
    }

    public JTextArea getMainField() {
        return mainField;
    }

    public boolean isTextForSendToServerExist() {
        return isTextForSendToServerExist;
    }

    private Component setMainField() {
        mainField = new JTextArea();
        mainField.setMargin(new Insets(0,10,10,10));
        mainField.setBackground(Color.LIGHT_GRAY);
        mainField.setFont(new Font("Times new roman", Font.BOLD, 18));
//        mainField.setRows(18);
        return mainField;
    }

    private Component setBottomPanel() {
        btnSend = new JButton(SEND_MESSAGE);
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().equals("")) {
                    isTextForSendToServerExist = false;
                } else {
                    mainField.append(textField.getText() + "\n");
                    isTextForSendToServerExist = true;
                    textField.setText("");
                }
            }
        });
        textField = new JTextField(35);
        bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(textField);
        bottomPanel.add(btnSend);
        return bottomPanel;
    }

    private Component setTopPanel() {
        ipField = new JTextField("  127.0.0.1");
        portField = new JTextField("  8189");
        nameField = new JTextField("  Ivan Ivanov");
        emptyField = new JTextField();
        passwordField = new JPasswordField("  sdfsdfsdfsdfse");
        btnLogin = new JButton("login");
        passwordField.setEchoChar('*');
        topPanel = new JPanel(new GridLayout(2, 3));
        topPanel.add(ipField);
        topPanel.add(portField);
        topPanel.add(emptyField);
        topPanel.add(nameField);
        topPanel.add(passwordField);
        topPanel.add(btnLogin);
        return topPanel;
    }
}
