package hw_4.Controllers;

import hw_4.elevator.State;
import hw_4.elevator.elevatorMovements;

import java.util.concurrent.BlockingQueue;

public class MainController implements Runnable{
    private elevatorMovements first;
    private elevatorMovements second;
    private int number = 20;
    private boolean working = true;

    private BlockingQueue<Requests> requests;

    public MainController(BlockingQueue<Requests> requests) {
        this.requests = requests;

        first = new elevatorMovements(1).setCurrentFloor(1).setState(State.IDLE);
        second = new elevatorMovements(2).setCurrentFloor(1).setState(State.IDLE);
    }
    MainController setFloorsNum(int number){
        this.number = number;
        return this;
    }


    @Override
    public void run() {
        while (working || !requests.isEmpty()){
            try{
                if (first.getState() == State.IDLE || second.getState() == State.IDLE){
                    Requests request = requests.poll();
                    if (request == null){
                        continue;
                    }

                    elevatorMovements best;
                    if (first.getState() == State.IDLE && second.getState() == State.IDLE){
                        if (Math.abs(first.getCurrentFloor() - request.getRequestFloor()) < Math.abs(second.getCurrentFloor() - request.getRequestFloor())){
                            best = first;
                        }
                        else{
                            best = second;
                        }
                    }
                    else if(first.getState() == State.IDLE){
                        best = first;
                    }
                    else if (second.getState() == State.IDLE){
                        best = second;
                    }
                    else{
                        continue;
                    }

                    System.out.println("Person ordered from floor " + request.getRequestFloor() + ", to direction " + request.getRoute()
                    + " is assigned to elevator ¹" + best.getId());

                    best.setRequests(requests).setFloorsNum(number)
                            .setRequestFloor(request.getRequestFloor())
                            .setState(request.getRequestFloor() >= best.getCurrentFloor() ? State.UP : State.DOWN)
                            .setRequestRoute(request.getRoute());

                    Thread elevatorThread = new Thread(best);
                    elevatorThread.start();

                }
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }

    public void stop(){
        this.working =false;
    }
}
