package gb.ru.seminar2HW.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI extends JFrame implements ServerView {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    JButton btnStart, btnStop;
    JTextArea log;
    Server server;

    public ServerGUI(){
        server = new Server(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);

        createPanel();

        setVisible(true);
    }

    public Server getServer() {
        return server;
    }

    @Override
    public void appendLog(String text){
        log.append(text + "\n");
    }

    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);
    }

    @Override
    public boolean takeServerPerformance() {
        return server.isWork();
    }

    @Override
    public void serverIsWorking() {
        server.doWorkTrue();
        appendLog("Сервер запущен!");
    }

    @Override
    public void serverStopWork() {
        server.stopWorking();
        appendLog("Сервер остановлен!");
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (takeServerPerformance()) {
                    appendLog("Сервер уже был запущен");
                } else {
                    serverIsWorking();
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!takeServerPerformance()) {
                    appendLog("Сервер уже был остановлен");
                } else {
                    serverStopWork();
                }
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }
}
