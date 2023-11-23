package gb.ru.seminar6HW;

import java.util.*;

public class Main {
    /*
    * В качестве задачи предлагаю вам реализовать код для демонстрации парадокса
    * Монти Холла (Парадокс Монти Холла — Википедия ) и наглядно убедиться в верности
    * парадокса (запустить игру в цикле на 1000 и вывести итоговый счет).
    * Необходимо:
    * Создать свой Java Maven или Gradle проект;
    * Самостоятельно реализовать прикладную задачу;
    * Сохранить результат в HashMap<шаг теста, результат>
    * Вывести на экран статистику по победам и поражениям
     */
    /*
    * Представьте, что вы стали участником игры, в которой вам нужно выбрать одну из трёх дверей.
    * За одной из дверей находится автомобиль, за двумя другими дверями — козы.
    * Вы выбираете одну из дверей, например, номер 1, после этого ведущий, который знает,
    * где находится автомобиль, а где — козы, открывает одну из оставшихся дверей, например, номер 3,
    * за которой находится коза. После этого он спрашивает вас — не желаете ли вы изменить свой
    * выбор и выбрать дверь номер 2? Увеличатся ли ваши шансы выиграть автомобиль, если вы примете
    * предложение ведущего и измените свой выбор?
    * Ведущий придерживается стратегии: предлагает сменить выбор в любом случае (не зависимо от того,
    * выбрал ли игрок авто или козу.
     */
    public static void main(String[] args) {
        HashMap<Integer, String> result = new HashMap<>();
        Random rand = new Random();
//        StringBuilder resultString = new StringBuilder();
        ArrayList<String> doors = new ArrayList<>(Arrays.asList("коза", "коза", "авто"));
        int choice = -1;
//        System.out.println(" шаг |  1 дверь  |  2 дверь  |  3 дверь  | если не менять выбор | если менять выбор");
        int n = 1001;
        for (int i = 1; i < n; i++) {
//            resultString.delete(0, resultString.length());
            Collections.shuffle(doors);
//            resultString.append("  " + i + "  |    " + doors.get(0) + "   |   " + doors.get(1) + "    |   " + doors.get(2));
            choice = rand.nextInt(0, 3);
//            resultString.append("    |         " + doors.get(choice));
            if (doors.get(choice).equals("авто")) {
//                resultString.append("         |         коза");
                result.put(i, "авто/коза");
            } else {
//                resultString.append("         |         авто");
                result.put(i, "коза/авто");
            }
//            System.out.println(resultString);
        }
        int count = 0;
        for (String value: result.values()) {
            if (value.equals("коза/авто")) count++;
        }
        System.out.println("Итого сделано " + (n - 1) + " шагов.");
        System.out.println("Если не менять выбор коза выпадает " + count + " раз, а авто - " + (n - 1 - count) + " раз");
        System.out.printf("Вероятность выпадения авто - %.1f%%\n", ((n - 1 - count) * 100. / (n - 1)));
        System.out.println("Если изменить выбор коза выпадает " + (n - 1 - count) + " раз, а авто - " + count + " раз.");
        System.out.printf("Вероятность выпадения авто - %.1f%%\n", (count * 100. / (n - 1)));
    }
}
