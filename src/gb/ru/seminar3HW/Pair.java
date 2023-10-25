package gb.ru.seminar3HW;

public class Pair<T1, T2> {
    /* 3.Напишите обобщенный класс Pair, который представляет собой" пару значений разного типа.
     * Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
     * а также переопределение метода toString(), возвращающее строковое представление пары.*/

    T1 x;
    T2 y;

    public Pair(T1 x, T2 y) {
        this.x = x;
        this.y = y;
    }

    T1 getFirst() {
        return x;
    }

    T2 getSecond() {
        return y;
    }

    @Override
    public String toString() {
        return "(x, y) = (" + getFirst() + ", " + getSecond() + ")\nкласс x => " + x.getClass() +
                "\nкласс y => " + y.getClass();
    }
}
