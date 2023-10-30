package gb.ru.seminar4;

import java.util.Collection;

public class Employee {
    /*
    * каждый сотрудник должен иметь следующие атрибуты:
        Табельный номер
        Номер телефона
        Имя
        Стаж*/
    private int idEmployee;
    private String nameEmployee;
    private String phoneNumber;
    private float seniorityEmployee;

    public Employee(int idEmployee, String nameEmployee, String phoneNumber, float seniorityEmployee) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.phoneNumber = phoneNumber;
        this.seniorityEmployee = seniorityEmployee;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public float getSeniorityEmployee() {
        return seniorityEmployee;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee=" + idEmployee +
                ", nameEmployee='" + nameEmployee + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", seniorityEmployee=" + seniorityEmployee +
                "}\n";
    }
}
