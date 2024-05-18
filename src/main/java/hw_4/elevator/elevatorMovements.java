package hw_4.elevator;

import hw_4.Controllers.Requests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class elevatorMovements implements Runnable{
    private int id;
    private int currentFloor;
    private State state;

    private int requestFloor;
    private State requestRoute;
    private int floorsNum;

    private BlockingQueue<Requests> requests;


    public elevatorMovements(int id) {
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public elevatorMovements setState(State state){
        this.state = state;
        return this;
    }
    public State getState(){
        return state;
    }
    public elevatorMovements setCurrentFloor(int currentFloor){
        this.currentFloor = currentFloor;
        return this;
    }
    public int getCurrentFloor(){
        return currentFloor;
    }

    public elevatorMovements setRequests(BlockingQueue<Requests> requests){
        this.requests = requests;
        return this;
    }
    public elevatorMovements setRequestFloor(int requestFloor){
        this.requestFloor = requestFloor;
        return this;
    }
    public elevatorMovements setRequestRoute(State requestRoute){
        this.requestRoute = requestRoute;
        return this;
    }
    public elevatorMovements setFloorsNum(int floorsNum){
        this.floorsNum = floorsNum;
        return this;
    }

    @Override
    public void run() {
        System.out.println("Elevator ¹" + id + " started his work");

        int step;
        if (state == State.UP){
            step = 1;
        }
        else{
            step = -1;
        }

        while (currentFloor != requestFloor){
            System.out.println("Now Elevator ¹" + id + " on floor " + currentFloor + ", his state - " + state);
            currentFloor += step;
            try{
                Thread.sleep(500);
            }catch (InterruptedException exception){
                exception.printStackTrace();
            }
        }

        System.out.println("Elevator ¹" + id + " catch person on floor " + currentFloor);

        state = requestRoute;
        if (requestRoute == State.UP){
            requestFloor = floorsNum;
        }
        else {
            requestFloor = 1;
        }

        List<Boolean> availableFloors;
        if (state == State.UP){
            step = 1;
        }
        else{
            step = -1;
        }

        while (currentFloor != requestFloor){
            System.out.println("Now Elevator ¹" + id + " on floor " + currentFloor + ", his state - " + state);

            availableFloors = getAvailableFloors();
            if (availableFloors.get(currentFloor)){
                System.out.println("Elevator ¹" + id + " catch person on floor " + currentFloor);

                removeRequests(currentFloor, state);
            }
            currentFloor += step;
            try{
                Thread.sleep(500);
            }catch (InterruptedException exception){
                exception.printStackTrace();
            }
        }
        System.out.println("Elevator ¹" + id + " finished ride");
        state = State.IDLE;
    }

    private List<Boolean> getAvailableFloors(){
        List<Boolean> list = new ArrayList<>(Collections.nCopies(floorsNum+1, false));

        for (Requests requests1 : requests){
            if (state == State.UP){
                if (requests1.getRequestFloor() >= currentFloor && requests1.getRoute() == state){
                    list.set(requests1.getRequestFloor(), true);
                }
            }
            if (state == State.DOWN){
                if (requests1.getRequestFloor() <= currentFloor && requests1.getRoute() == state){
                    list.set(requests1.getRequestFloor(), true);
                }
            }
        }
        return list;
    }

    private void removeRequests(int requestFloor, State route){
        for (Requests requests1 : requests){
            if (requestFloor == requests1.getRequestFloor() && route == requests1.getRoute()){
                requests.remove(requests1);
            }
        }
    }
}
