package gb.ru.seminar5HW;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Table extends Thread {
    private List<Thinker> thinkers;
    private CountDownLatch cdl;

    public Table() {
        cdl = new CountDownLatch(5);
        thinkers = new ArrayList<>(5);
        thinkers.add(new Thinker("Сократ", cdl));
        thinkers.add(new Thinker("Платон", cdl));
        thinkers.add(new Thinker("Аристотель", cdl));
        thinkers.add(new Thinker("Солон", cdl));
        thinkers.add(new Thinker("Пифагор", cdl));
    }

    @Override
    public void run() {
        for (Thinker thinker: thinkers) {
            if (thinker.isEat()) thinker.changeEat();
            thinker.start();
            try {
                Thread.sleep(1000);
                thinker.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            cdl.await();
            System.out.println("Все собрались!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int j = 0; j < 5; j++){
            System.out.println("\nПиршество номер " + (j + 1) + " началось!");
            int k = j;
            if (j >= 3) k = j - 5;
            for (int i = 0; i < 5; i++) {
                if (i == j || i == k + 2) thinkers.get(i).changeEat();
                thinkers.get(i).go();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                cdl.await();
                System.out.println("Пиршество номер " + (j + 1) + " завершилось!");
                System.out.println("Смена блюд...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (Thinker thinker: thinkers) {
                if (thinker.isEat()) thinker.changeEat();
            }
        }
    }
}
