package gb.ru.seminar2HW.client;

import gb.ru.seminar2HW.server.Server;

public class Client {
    //здесь - сама логика, граф интерфейс - только метод printMessage
    private String name;
    private ClientView clientView;
    private Server server;
    private boolean connected;

    public Client(ClientView clientView, Server server) {
        this.clientView = clientView;
        this.server = server;
    }

    public Server getServer() {
        return server;
    }

    // подключение к серверу
    public boolean connectToServer(String name) {
        this.name = name;
        if (server.connectUser(this)) {
            printText("Вы успешно подключились!");
            connected = true;
            String log = server.getHistory();
            if (log != null) {
                printText(log);
            }
            return true;
        } else {
            printText("Подключение не удалось");
            return false;
        }
    }

    // клиент посылает сообщение (мы посылаем)
    public void sendMessage(String message) {
        if (connected) {
            if (!message.isEmpty()) {
                server.sendMessage(name + ": " + message);
            }
        } else {
            printText("Нет подключения к серверу");
        }
    }

    // сервер возвращает ответ, получение ответа от сервера (нам посылают)
    public void serverAnswer(String answer) {
        printText(answer);
    }

    // отключение
    public void disconnect() {
        if (connected) {
            connected = false;
            clientView.disconnectFromServer();
            server.disconnectUser(this);
            printText("Вы были отключены от сервера!");
        }
    }

    public String getName() {
        return name;
    }

    // обращение к view для отображения текста
    public void printText(String text) {
        clientView.showMessage(text);
    }
}
