package ua.edu.chnu.kkn.solid_violation.ocp;

public abstract class Employee {

    protected int salary;
    protected int bonus;


    public Employee(int salary, int bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    public abstract int payAmount();

}
