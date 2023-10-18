package gb.ru.seminar2HW.server;

public interface ServerView {
    void appendLog(String text);
    boolean takeServerPerformance();
    void serverIsWorking();
    void serverStopWork();
}
