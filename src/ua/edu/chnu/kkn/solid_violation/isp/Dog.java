package ua.edu.chnu.kkn.solid_violation.isp;

public class Dog implements Barking, Running {
    @Override
    public void bark() {
        System.out.println("Dog's barking.");
    }

    @Override
    public void run() { System.out.println("Dog's running."); }
}

