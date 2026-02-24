package ua.edu.chnu.kkn.solid_violation.isp;

public class Bird implements Flying, Running {
    @Override
    public void fly(){
        System.out.println("Bird's flying.");
    }

    @Override
    public void run() { System.out.println("Bird's running."); }
}
