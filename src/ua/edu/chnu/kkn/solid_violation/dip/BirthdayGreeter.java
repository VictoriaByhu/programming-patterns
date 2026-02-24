package ua.edu.chnu.kkn.solid_violation.dip;

import java.time.MonthDay;

public class BirthdayGreeter {
    private final EmployeeRepository employeeRepository;
    private final Clock clock;
    private final MessageSender messageSender;

    public BirthdayGreeter(EmployeeRepository employeeRepository, Clock clock, MessageSender messageSender) {
        this.employeeRepository = employeeRepository;
        this.clock = clock;
        this.messageSender = messageSender;
    }

    public void sendGreetings() {
        MonthDay today = clock.monthDay();
        employeeRepository.findEmployeesBornOn(today)
                .stream()
                .map(this::emailFor)
                .forEach(MessageSender::send);
    }

    private Email emailFor(Employee employee) {
        String message = String.format("Happy birthday, dear %s!", employee.getFirstName());
        return new Email(employee.getEmail(), "Happy birthday!", message);
    }
}
