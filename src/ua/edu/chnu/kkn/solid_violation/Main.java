package ua.edu.chnu.kkn.solid_violation;

import ua.edu.chnu.kkn.solid_violation.isp.Bird;
import ua.edu.chnu.kkn.solid_violation.isp.Dog;
import ua.edu.chnu.kkn.solid_violation.lsp.ElectricCar;
import ua.edu.chnu.kkn.solid_violation.lsp.FillingStation;
import ua.edu.chnu.kkn.solid_violation.lsp.PetrolCar;
import ua.edu.chnu.kkn.solid_violation.ocp.Employee;
import ua.edu.chnu.kkn.solid_violation.ocp.Engineer;
import ua.edu.chnu.kkn.solid_violation.ocp.Manager;
import ua.edu.chnu.kkn.solid_violation.srp.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("-SRP Check-");
        Console console = new Console();
        Clock clock = new Clock();
        TransactionRepository repository = new InMemoryTransactionRepository();
        StatementPrinter printer = new StatementPrinter(console);

        AccountService accountService = new AccountService(repository, clock, printer);

        accountService.deposit(1000);
        accountService.withdraw(100);
        accountService.deposit(500);
        accountService.printStatement();
        System.out.println();

        System.out.println("-OCP Check-");
        List<Employee> employees = List.of(
                new Engineer(3000, 500), // Отримує тільки salary
                new Manager(4000, 1000)   // Отримує salary + bonus
        );

        for (Employee emp : employees) {
            System.out.println("Employee pay amount: " + emp.payAmount());
        }
        System.out.println();



        System.out.println("-LSP Check-");
        FillingStation station = new FillingStation();

        PetrolCar petrolCar = new PetrolCar();
        ElectricCar electricCar = new ElectricCar();

        station.refuel(petrolCar);
        station.charge(electricCar);

        System.out.println("Petrol tank level: " + petrolCar.fuelTankLevel());
        System.out.println("Electric battery level: " + electricCar.batteryLevel());


        System.out.println("-ISP Check-");

        Bird swallow = new Bird();
        swallow.fly();
        swallow.run();

        Dog shepherd = new Dog();
        shepherd.bark();
        shepherd.run();
    }

}
