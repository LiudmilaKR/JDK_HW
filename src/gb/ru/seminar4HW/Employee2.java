package gb.ru.seminar4HW;

import java.util.List;

public class Employee2 {
    private String nameEmployee;
    private List<String> phoneNumber;
    private float seniorityEmployee;

    public Employee2(String nameEmployee, List<String> phoneNumber, float seniorityEmployee) {
        this.nameEmployee = nameEmployee;
        this.phoneNumber = phoneNumber;
        this.seniorityEmployee = seniorityEmployee;
    }

        public String getNameEmployee() {
        return nameEmployee;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    public float getSeniorityEmployee() {
        return seniorityEmployee;
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "nameEmployee='" + nameEmployee + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", seniorityEmployee=" + seniorityEmployee +
                "}\n";
    }
}
