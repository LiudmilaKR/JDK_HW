package gb.ru.seminar4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
    * Создать справочник сотрудников
    * Необходимо:
    * Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников -
    * каждый сотрудник должен иметь следующие атрибуты:
        Табельный номер
        Номер телефона
        Имя
        Стаж
    Добавить метод, который ищет сотрудника по стажу (может быть список)
    Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
    Добавить метод, который ищет сотрудника по табельному номеру
    Добавить метод добавление нового сотрудника в справочник*/
    public static void main(String[] args) {
        ListEmployees listEmployees = new ListEmployees();
        listEmployees.addEmployeeToList(new Employee(14, "Василий", "234", 3.4f));
        listEmployees.addEmployeeToList(new Employee(25, "Пётр", "4538", 23.0f));
        listEmployees.addEmployeeToList(new Employee(14, "Василий", "25497", 8.1f));
        System.out.println(listEmployees);
        System.out.println();
        listEmployees.searchEmployeeBySeniority(23.0f);
        listEmployees.searchPhoneNumber("Анна");
        listEmployees.searchEmployeeByID(25);

        System.out.println();
        ListEmployees2 listEmployees2 = new ListEmployees2();
        listEmployees2.addEmployeeToList(new Employee2("Василий", List.of("456", "123245"), 3.4f));
        listEmployees2.addEmployeeToList(new Employee2("Сергей", List.of("1236"), 23.0f));
        listEmployees2.addEmployeeToList(new Employee2("Анна", List.of("93457673246", "s5435", "677"), 8.1f));
        listEmployees2.addEmployeeToList(new Employee2("Сергей", List.of("93457673246", "s5435", "677"), 5.3f));
        listEmployees2.addEmployeeToList(new Employee2("Елена", List.of("93457673246", "s5435", "677"), 8.1f));
        System.out.println(listEmployees2);
        listEmployees2.searchEmployeeBySeniority(8.1f);
        listEmployees2.searchPhoneNumber("Сергей");
        listEmployees2.searchEmployeeByID(14);
    }
}
