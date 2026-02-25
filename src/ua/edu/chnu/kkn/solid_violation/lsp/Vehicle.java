package ua.edu.chnu.kkn.solid_violation.lsp;

public abstract class Vehicle {


    private boolean engineStarted = false;

    public void startEngine() {
        this.engineStarted = true;
    }

    public boolean engineIsStarted() {
        return engineStarted;
    }

    public void stopEngine() {
        this.engineStarted = false;
    }






}
