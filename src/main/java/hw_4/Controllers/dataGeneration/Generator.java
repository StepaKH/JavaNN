package hw_4.Controllers.dataGeneration;

import hw_4.Controllers.Requests;
import hw_4.elevator.State;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Generator implements Runnable{

    private int floorsNumber = 20;
    private int delay = 500;
    private int requestsCount = 1;
    private BlockingQueue<Requests> requests;

    public Generator(BlockingQueue<Requests> requests) {
        this.requests = requests;
    }
    public Generator setFloorsNum(int floorsNumber){
        this.floorsNumber = floorsNumber;
        return this;
    }
    public Generator setDelay(int delay){
        this.delay = delay;
        return this;
    }
    public Generator setRequestsCount(int requestsCount){
        this.requestsCount = requestsCount;
        return this;
    }


    @Override
    public void run() {
        Random random = new Random(42);

        while (requestsCount-- > 0){
            int floor = Math.abs(random.nextInt()) % floorsNumber + 1;
            State direction = random.nextInt() % 2 == 0 ? State.UP : State.DOWN;

            if (floor == floorsNumber && direction == State.UP){
                floor--;
            }
            if (floor == 1 && direction == State.DOWN){
                floor++;
            }

            System.out.println("A request was made: floor " + floor + " direction " + direction);
            requests.add(new Requests(floor, direction));

            try {
                Thread.sleep(delay);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }
}
