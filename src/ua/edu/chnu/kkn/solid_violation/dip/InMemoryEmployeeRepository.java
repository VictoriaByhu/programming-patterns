package ua.edu.chnu.kkn.solid_violation.dip;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryEmployeeRepository implements EmployeeRepository {
    private final List<Employee> employees = List.of(
            new Employee("Ivan", "Petrenko", LocalDate.of(1995, 5, 20), "ivan@example.com"),

            new Employee("Petro", "Berezovskyi", LocalDate.now(), "happy@example.com")
    );

    @Override
    public List<Employee> findEmployeesBornOn(MonthDay monthDay) {
        return employees.stream()
                .filter(e -> MonthDay.from(e.getDateOfBirth()).equals(monthDay))
                .collect(Collectors.toList());
    }
}
