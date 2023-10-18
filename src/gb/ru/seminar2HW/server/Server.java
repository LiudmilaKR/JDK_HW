package gb.ru.seminar2HW.server;

import gb.ru.seminar2HW.client.Client;

import java.util.ArrayList;
import java.util.List;

public class Server {
    ServerGUI serverGUI;
    Repo fileRepo;
    List<Client> clientList;
    boolean work;

    public Server(ServerGUI serverGUI) {
        this.serverGUI = serverGUI;
        clientList = new ArrayList<>();
        fileRepo = new RepoFile();
    }

    public boolean isWork() {
        return work;
    }

    public void doWorkTrue() {
        work = true;
    }

    public void stopWorking() {
        work = false;
        for (int i = clientList.size() - 1; i >= 0; i--) {
            disconnectUser(clientList.get(i));
        }
    }

    public boolean connectUser(Client client){
        if (!work){
            return false;
        }
        clientList.add(client);
        return true;
    }


    public String getHistory() {
        return fileRepo.readLog();
    }

    public void disconnectUser(Client client){
        clientList.remove(client);
        if (client != null){
            client.disconnect();
        }
    }

    public void sendMessage(String text){
        if (!work){
            return;
        }
        serverGUI.appendLog(text);
        answerAll(text);
        fileRepo.saveInLog(text);
    }

    private void answerAll(String text){
        for (Client client: clientList){
            client.printText(text);
        }
    }
}
