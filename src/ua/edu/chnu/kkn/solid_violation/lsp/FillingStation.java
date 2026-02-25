package ua.edu.chnu.kkn.solid_violation.lsp;

public class FillingStation {

    public void refuel(Refuellable vehicle){
        vehicle.fillUpWithFuel();
    }

    public void charge(Chargeable vehicle){
        vehicle.chargeBattery();
    }
}
