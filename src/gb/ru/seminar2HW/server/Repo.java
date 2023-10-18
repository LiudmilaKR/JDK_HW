package gb.ru.seminar2HW.server;

public interface Repo {
    void saveInLog(String text);
    String readLog();
}
