package gb.ru.seminar3HW;

public class Calculator {
    /*
    * 1.Написать класс Калькулятор (необобщенный), который содержит обобщенные
    * статические методы: sum(), multiply(), divide(), subtract().
    * Параметры этих методов – два числа разного типа (но необязательно разного между собой),
    * над которыми должна быть произведена операция.*/

//    Делаю без проверки Integer.MAX_VALUE, и так получилось очень громоздко...:)

     public static <T1 extends Number, T2 extends Number> void sum(T1 a, T2 b) {
//         решение преподавателя - использование num1.doubleValue() and num2.doubleValue()
        if (a instanceof Integer) {
            if (b instanceof Integer) System.out.printf("%d + %d = %d\n", a, b, a.intValue() + b.intValue());
            else if (b instanceof Float) System.out.printf("%d + %f = %f\n", a, b, a.intValue() + b.floatValue());
            else if (b instanceof Double) System.out.printf("%d + %f = %f\n", a, b, a.intValue() + b.doubleValue());
        } else if (a instanceof Float) {
            if (b instanceof Integer) System.out.printf("%f + %d = %f\n", a, b, a.floatValue() + b.intValue());
            else if (b instanceof Float) System.out.printf("%f + %f = %f\n", a, b, a.floatValue() + b.floatValue());
            else if (b instanceof Double) System.out.printf("%f + %f = %f\n", a, b, a.floatValue() + b.doubleValue());
        } else if (a instanceof Double) {
            if (b instanceof Integer) System.out.printf("%f + %d = %f\n", a, b, a.doubleValue() + b.intValue());
            else if (b instanceof Float) System.out.printf("%f + %f = %f\n", a, b, a.doubleValue() + b.floatValue());
            else if (b instanceof Double) System.out.printf("%f + %f = %f\n", a, b, a.doubleValue() + b.doubleValue());
        } System.out.println("Что-то пошло не так...");
    }

    public static <T1 extends Number, T2 extends Number> void multiply(T1 a, T2 b) {
        if (a instanceof Integer) {
            if (b instanceof Integer) System.out.printf("%d * %d = %d\n", a, b, a.intValue() * b.intValue());
            else if (b instanceof Float) System.out.printf("%d * %f = %f\n", a, b, a.intValue() * b.floatValue());
            else if (b instanceof Double) System.out.printf("%d * %f = %f\n", a, b, a.intValue() * b.doubleValue());
        } else if (a instanceof Float) {
            if (b instanceof Integer) System.out.printf("%f * %d = %f\n", a, b, a.floatValue() * b.intValue());
            else if (b instanceof Float) System.out.printf("%f * %f = %f\n", a, b, a.floatValue() * b.floatValue());
            else if (b instanceof Double) System.out.printf("%f * %f = %f\n", a, b, a.floatValue() * b.doubleValue());
        } else if (a instanceof Double) {
            if (b instanceof Integer) System.out.printf("%f * %d = %f\n", a, b, a.doubleValue() * b.intValue());
            else if (b instanceof Float) System.out.printf("%f * %f = %f\n", a, b, a.doubleValue() * b.floatValue());
            else if (b instanceof Double) System.out.printf("%f * %f = %f\n", a, b, a.doubleValue() * b.doubleValue());
        } System.out.println("Что-то пошло не так...");
    }

    public static <T1 extends Number, T2 extends Number> void subtract(T1 a, T2 b) {
        if (a instanceof Integer) {
            if (b instanceof Integer) System.out.printf("%d - %d = %d\n", a, b, a.intValue() - b.intValue());
            else if (b instanceof Float) System.out.printf("%d - %f = %f\n", a, b, a.intValue() - b.floatValue());
            else if (b instanceof Double) System.out.printf("%d - %f = %f\n", a, b, a.intValue() - b.doubleValue());
        } else if (a instanceof Float) {
            if (b instanceof Integer) System.out.printf("%f - %d = %f\n", a, b, a.floatValue() - b.intValue());
            else if (b instanceof Float) System.out.printf("%f - %f = %f\n", a, b, a.floatValue() - b.floatValue());
            else if (b instanceof Double) System.out.printf("%f - %f = %f\n", a, b, a.floatValue() - b.doubleValue());
        } else if (a instanceof Double) {
            if (b instanceof Integer) System.out.printf("%f - %d = %f\n", a, b, a.doubleValue() - b.intValue());
            else if (b instanceof Float) System.out.printf("%f - %f = %f\n", a, b, a.doubleValue() - b.floatValue());
            else if (b instanceof Double) System.out.printf("%f - %f = %f\n", a, b, a.doubleValue() - b.doubleValue());
        } else System.out.println("Что-то пошло не так...");
    }

    public static <T1 extends Number, T2 extends Number> void divide(T1 a, T2 b) throws ArithmeticException {
         try {
            if (a instanceof Integer) {
                if (b instanceof Integer) System.out.printf("%d / %d = %d\n", a, b, a.intValue() / b.intValue());
                else if (b instanceof Float) System.out.printf("%d / %f = %f\n", a, b, a.intValue() / b.floatValue());
                else if (b instanceof Double) System.out.printf("%d / %f = %f\n", a, b, a.intValue() / b.doubleValue());
            } else if (a instanceof Float) {
                if (b instanceof Integer) System.out.printf("%f / %d = %f\n", a, b, a.floatValue() / b.intValue());
                else if (b instanceof Float) System.out.printf("%f / %f = %f\n", a, b, a.floatValue() / b.floatValue());
                else if (b instanceof Double)
                    System.out.printf("%f / %f = %f\n", a, b, a.floatValue() / b.doubleValue());
            } else if (a instanceof Double) {
                if (b instanceof Integer) System.out.printf("%f / %d = %f\n", a, b, a.doubleValue() / b.intValue());
                else if (b instanceof Float)
                    System.out.printf("%f / %f = %f\n", a, b, a.doubleValue() / b.floatValue());
                else if (b instanceof Double)
                    System.out.printf("%f / %f = %f\n", a, b, a.doubleValue() / b.doubleValue());
            }
         } catch (ArithmeticException e) {
             System.out.println(a + " / " + b + " - ошибка " + e.getMessage() + "\nДеление на ноль запрещено!");
        }
    }
//    //         решение преподавателя
    public static <T extends  Number> double sum1(T num1, T num2) {
         return num1.doubleValue() + num2.doubleValue();
    }
}
