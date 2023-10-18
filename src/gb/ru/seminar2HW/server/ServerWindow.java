package gb.ru.seminar2HW.server;

import gb.ru.seminar2HW.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ServerWindow extends JFrame{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

//    Repo fileRepo;
//    List<Client> clientList;

    JButton btnStart, btnStop;
    JTextArea log;
//    boolean work;
    Server server;

    public ServerWindow(){
//        clientList = new ArrayList<>();
//        fileRepo = new RepoFile();
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

    //    public boolean connectUser(Client client){
//        if (!work){
//            return false;
//        }
//        clientList.add(client);
//        return true;
//    }
//
//    public String getHistory() {
////        return readLog();
//        return fileRepo.readLog();
//    }
//
//    public void disconnectUser(Client client){
//        clientList.remove(client);
//        if (client != null){
//            client.disconnect();
//        }
//    }

//    public void sendMessage(String text){
//        if (!work){
//            return;
//        }
//        appendLog(text);
//        answerAll(text);
////        saveInLog(text);
//        fileRepo.saveInLog(text);
//    }
//
//    private void answerAll(String text){
//        for (Client client: clientList){
//            client.printText(text);
//        }
//    }
//
    public void appendLog(String text){
        log.append(text + "\n");
    }

    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                if (work){
                if (server.isWork()) {
                    appendLog("Сервер уже был запущен");
                } else {
//                    work = true;
                    server.doWorkTrue();
                    appendLog("Сервер запущен!");
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                if (!work){
                if (!server.isWork()) {
                    appendLog("Сервер уже был остановлен");
                } else {
//                    work = false;
                    server.stopWorking();
//                    for (Client client: clientList){
//                        disconnectUser(client);
//                    }
                    //TODO
                    appendLog("Сервер остановлен!");
                }
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }
}
