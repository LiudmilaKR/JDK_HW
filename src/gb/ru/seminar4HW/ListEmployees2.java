package gb.ru.seminar4HW;

import java.util.*;

public class ListEmployees2 {
    Map<Integer, Employee2> employeeList;

    public ListEmployees2() {
        employeeList = new HashMap<Integer, Employee2>();
    }

    public void addEmployeeToList(Employee2 employee) {
        Random rand = new Random();
        int id;
        do {
            id = rand.nextInt(11, 20);
        } while (employeeList.containsKey(id));
        employeeList.put(id, employee);
    }

    /**
     * Поиск сотрудников по стажу
     * @param seniority - стаж
     */
    public void searchEmployeeBySeniority(float seniority) {
        List<String> employeesWithSeniority = new ArrayList<>();
        for (Map.Entry<Integer, Employee2> entry: employeeList.entrySet()) {
            if (entry.getValue().getSeniorityEmployee() == seniority) {
                employeesWithSeniority.add(entry.getValue().getNameEmployee()
                            + " (табельный номер " + entry.getKey() + ")\n");
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
        List<String> names = new ArrayList<>();
        for (Map.Entry<Integer, Employee2> entry: employeeList.entrySet()) {
            if (entry.getValue().getNameEmployee().equals(name)) {
                names.add("Телефоны сотрудника по имени " + name
                        + " с табельным номером " + entry.getKey() + " " + entry.getValue().getPhoneNumber() + '\n');
            }
        }
        if (names.isEmpty()) System.out.println("Сотрудник по имени " + name + " не найден.");
        else System.out.println(names);
    }

    /**
     * Поиск сотрудника по таблельному номеру
     * @param id - табельный номер
     */
    public void searchEmployeeByID(int id) {
        Employee2 searched = null;
        for (Map.Entry<Integer, Employee2> entry: employeeList.entrySet()) {
            if (entry.getKey() == id) searched = entry.getValue();
        }
        if (searched == null) System.out.println("Сотрудник с id=" + id + " не найден.");
        else System.out.println("Сотрудник с id=" + id + " - это " + searched);
    }

    @Override
    public String toString() {
        return "ListEmployees2{" + employeeList + '}';
    }
}
