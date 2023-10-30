package gb.ru.seminar4HW;

import java.util.ArrayList;
import java.util.List;

public class ListEmployees {
    /*
    * Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников
    * Добавить метод, который ищет сотрудника по стажу (может быть список)
    * Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
    * Добавить метод, который ищет сотрудника по табельному номеру
    * Добавить метод добавление нового сотрудника в справочник*/
    private List<Employee> employeeList;

    public ListEmployees() {
        employeeList = new ArrayList<>();
    }

    public void addEmployeeToList (Employee employee) {
        employeeList.add(employee);
    }

    /**
     * Поиск сотрудников по стажу
     * @param seniority - стаж
     */
    public void searchEmployeeBySeniority(float seniority) {
        List<String> employeesWithSeniority = new ArrayList<>();
        for (Employee employee: employeeList) {
            if (employee.getSeniorityEmployee() == seniority) {
                employeesWithSeniority.add(employee.getNameEmployee() + " (табельный номер "
                        + employee.getIdEmployee() + ")\n");
            }
        }
        if (employeesWithSeniority.isEmpty()) {
            System.out.println("Сотрудник со стажем " + seniority + " лет не найден.");
        }
        else {
            System.out.println("Сотрудники со стажем " + seniority + " лет:\n" + employeesWithSeniority);
        }
    }

    /**
     * Вывод номера телефона сотрудника по имени
     * @param name имя сотрудника
     */
    public void searchPhoneNumber(String name) {
        List<String> phones = new ArrayList<>();
        employeeList.stream().forEach(item -> {
            if (item.getNameEmployee().equals(name)) {
                phones.add("у сотрудника " + item.getNameEmployee() + " (таб номер " + item.getIdEmployee()
                        + ") номер телефона " + item.getPhoneNumber() + '\n');
            }
        });
        if (phones.isEmpty()) System.out.println("Сотрудник по имени " + name + " не найден.");
        else System.out.println(phones);
    }

    /**
     * Поиск сотрудника по таблельному номеру
     * @param id - табельный номер
     */
    public void searchEmployeeByID(int id) {
        Employee searched = null;
        for (Employee employee: employeeList) {
            if (employee.getIdEmployee() == id) searched = employee;
        }
        if (searched == null) System.out.println("Сотрудник с id=" + id + " не найден.");
        else System.out.println("Сотрудник с id=" + id + " - это " + searched);
    }

    @Override
    public String toString() {
        return "Список сотрудников\n" + employeeList;
    }
}
