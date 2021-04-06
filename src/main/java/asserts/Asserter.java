package asserts;

import employee.Employee;

import java.util.ArrayList;

public class Asserter {
    public static void assertIncrementScheduleSize(int originalScheduleLength, Employee person) {
        assert originalScheduleLength == person.getSchedules().size() + 1 : "1 schedule " +
                "is supposed to be dropped.";
    }

    public static void assertPositiveVacancies(int vacancy) {
        assert vacancy > 0;
    }

    public static void assertNonNullEmployees(ArrayList<Employee> employees) {
        assert employees != null;
    }
}
