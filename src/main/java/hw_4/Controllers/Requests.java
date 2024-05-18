package hw_4.Controllers;

import hw_4.elevator.State;

public class Requests {
    private int requestFloor;
    private State route;

    public Requests(int requestFloor, State route) {
        this.requestFloor = requestFloor;
        this.route = route;
    }

    public int getRequestFloor() {
        return requestFloor;
    }
    public State getRoute() {
        return route;
    }
}
