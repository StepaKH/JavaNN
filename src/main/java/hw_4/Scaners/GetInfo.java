package hw_4.Scaners;

import hw_4.Controllers.MainController;
import hw_4.Controllers.Requests;
import hw_4.Controllers.dataGeneration.Generator;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GetInfo {
    private int delay;
    private int requestsCount;
    private int floors;

    public Scanner scanner = new Scanner(System.in);

    public void get(){
        System.out.println("Enter number of floors:");
        floors = scanner.nextInt();

        System.out.println("Enter delay in millisecs:");
        delay = scanner.nextInt();

        System.out.println("Enter count of requests:");
        requestsCount = scanner.nextInt();

        scanner.close();

        run();
    }

    private void run(){
        BlockingQueue<Requests> requests = new LinkedBlockingQueue<>();
        MainController mainController = new MainController(requests);
        Generator generator = new Generator(requests)
                .setDelay(delay)
                .setFloorsNum(floors)
                .setRequestsCount(requestsCount);

        Thread thread1 = new Thread(mainController);
        Thread thread2 = new Thread(generator);

        thread1.start();
        thread2.start();

        try {
            thread2.join();
        }catch (Exception exception){
            exception.printStackTrace();
        }

        mainController.stop();
    }
}
