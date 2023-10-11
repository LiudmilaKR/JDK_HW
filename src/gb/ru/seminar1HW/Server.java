package gb.ru.seminar1HW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class Server extends JFrame {
    private static final int WIN_WIDTH = 450;
    private static final int WIN_HIGH = 450;
    private static final int WIN_X = 300;
    private static final int WIN_Y = 200;
    private static final String TITLE = "Server";
    private static final String START_MESSAGE = "start";
    private static final String STOP_MESSAGE = "stop";
    private static final String Exit_MESSAGE = "exit";

    private JButton btnStart, btnStop, btnExit;
    private JPanel bottomPanel;
    private JTextArea mainField;
    private boolean isStartWorking = false;
    private boolean isStopWorking = true;
    Client client;

    Server() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WIN_X, WIN_Y);
        setSize(WIN_WIDTH, WIN_HIGH);
        setTitle(TITLE);
        setResizable(false);

        add(setMainField());
        add(setBottomPanel(), BorderLayout.SOUTH);

        setVisible(true);
    }

    public boolean isStartWorking() {
        return isStartWorking;
    }

    private Component setBottomPanel() {
        btnStart = new JButton(START_MESSAGE);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startActions();
                logging();
            }
        });
        btnStop = new JButton(STOP_MESSAGE);
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopActions();
                logging();
            }
        });
        btnExit = new JButton(Exit_MESSAGE);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        bottomPanel = new JPanel(new GridLayout(1, 3));
        bottomPanel.add(btnStart);
        bottomPanel.add(btnStop);
        bottomPanel.add(btnExit);
//        setContentPane(bottomPanel);
        return bottomPanel;
    }

    private Component setMainField() {
        mainField = new JTextArea();
        mainField.setMargin(new Insets(0,10,10,10));
        mainField.setBackground(Color.LIGHT_GRAY);
        mainField.setFont(new Font("Times new roman", Font.BOLD, 18));
//        mainField.setRows(18);
        return mainField;
    }

    private void startActions() {
        if (isStartWorking) {
            mainField.append("\nСервер работает!");
            client.getMainField().setText(mainField.getText() + "\n");
        } else {
            if (client == null) client = new Client();
            mainField.append("\nСервер запущен!");
            client.getMainField().setText(mainField.getText() + "\n");
            isStartWorking = true;
            isStopWorking = false;
        }
//        if (mainField.getLineCount() > 18;
    }

    private void stopActions() {
        if (isStopWorking) {
            mainField.append("\nСервер не работает!");
            client.getMainField().setText(mainField.getText() + "\n");
        } else {
            mainField.append("\nСервер остановлен!");
            client.getMainField().setText(mainField.getText() + "\n");
            isStartWorking = false;
            isStopWorking = true;
        }
    }

    private void logging() {
        try {
            FileWriter fw = new FileWriter("log.txt", true);
            fw.append(mainField.getText());
            fw.append('\n');
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
