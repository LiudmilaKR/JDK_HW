package gb.ru.seminar2HW.server;

import gb.ru.seminar2HW.client.Client;

import java.util.ArrayList;
import java.util.List;

public class Server {
    ServerWindow serverWindow;
    Repo fileRepo;
    List<Client> clientList;
    boolean work;

    public Server(ServerWindow serverWindow) {
        this.serverWindow = serverWindow;
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
        for (Client client: clientList){
            disconnectUser(client);
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
//        return readLog();
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
        serverWindow.appendLog(text);
//        appendLog(text);
        answerAll(text);
//        saveInLog(text);
        fileRepo.saveInLog(text);
    }

    private void answerAll(String text){
        for (Client client: clientList){
            client.printText(text);
        }
    }



}
