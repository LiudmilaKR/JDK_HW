package gb.ru.seminar5HW;

import java.util.concurrent.CountDownLatch;

public class Thinker extends Thread {
    private String name;
    private CountDownLatch cdl;
//    если eat=true - филосов ест, иначе - размышляет
    private boolean eat;

    public Thinker(String name, CountDownLatch cdl) {
        this.name = name;
        this.cdl = cdl;
        eat = false;
    }

    public boolean isEat() {
        return eat;
    }

    public void changeEat() {
        if (eat) eat = false;
        else eat = true;
    }

    @Override
    public void run() {
        System.out.println("философ " + name + " сел за стол");
        cdl.countDown();
    }

    public void go() {
        if (eat) System.out.println("философ " + name + " ест");
        else System.out.println("философ " + name + " размышляет");
    }
}
