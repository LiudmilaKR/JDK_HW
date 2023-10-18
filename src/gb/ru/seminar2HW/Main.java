package gb.ru.seminar2HW;

import gb.ru.seminar2HW.client.ClientGUI;
import gb.ru.seminar2HW.server.ServerGUI;

public class Main {
    public static void main(String[] args) {
        ServerGUI serverWindow = new ServerGUI();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}
