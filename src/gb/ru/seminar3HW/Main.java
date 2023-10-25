package gb.ru.seminar3HW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    /*
    * 1.Написать класс Калькулятор (необобщенный), который содержит обобщенные
    * статические методы: sum(), multiply(), divide(), subtract().
    * Параметры этих методов – два числа разного типа (но необязательно разного между собой),
    * над которыми должна быть произведена операция.
    *
    * 2.Напишите обобщенный метод compareArrays(), который принимает два массива и
    * возвращает true, если они одинаковые, и false в противном случае.
    * Массивы могут быть любого типа данных, но должны иметь одинаковую длину и содержать элементы одного типа.
    *
    * 3.Напишите обобщенный класс Pair, который представляет собой" пару значений разного типа.
    * Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из составляющих пары,
    * а также переопределение метода toString(), возвращающее строковое представление пары.*/
    public static void main(String[] args) {
        System.out.println("Задача 1");
        Calculator.sum(5.3f, 6);
        Calculator.multiply(501, -69);
        Calculator.subtract(56.6, 986.4f);
        Calculator.divide(45, 0);
        Calculator.divide(5, 345.4f);
        System.out.println();

        System.out.println("Задача 2");
        List<Integer> array1 = Arrays.asList(1, 2, 5);
        List<Integer> array2 = Arrays.asList(1, 2, 5);
        System.out.printf("результат сравнения массива %s и массива %s - %s\n",
                array1.toString(), array2.toString(), compareArrays1(array1, array2));
        String[] arr1 = new String[]{"3", "hello"};
        String[] arr2 = new String[]{"3", "hello"};
        System.out.printf("результат сравнения массива %s и массива %s - %s\n",
                Arrays.toString(arr1), Arrays.toString(arr2), compareArrays2(arr1, arr2));
        System.out.println();

        System.out.println("Задача 3");
        Pair<String, Float> pair = new Pair<>("hello...", 4.8f);
        System.out.println(pair.toString());

    }

    private static <E> boolean compareArrays1(List<E> ar1, List<E> ar2) {
        return ar1.equals(ar2);
    }

    private static boolean compareArrays2(Object[] ar1, Object[] ar2) {
        return Arrays.equals(Arrays.stream(ar1).toArray(), Arrays.stream(ar2).toArray());
    }
}
