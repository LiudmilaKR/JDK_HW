package gb.ru.seminar2HW;

import gb.ru.seminar2HW.client.ClientGUI;
import gb.ru.seminar2HW.server.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}
