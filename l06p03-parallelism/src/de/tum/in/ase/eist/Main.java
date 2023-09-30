package de.tum.in.ase.eist;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        detectDeadlock(new SwimmingPool());
    }

    public static void detectDeadlock(SwimmingPool swimmingPool) {
        Runnable men1 = new Runnable() {
            public void run() {
                Swimmer swimmer = new Swimmer();
                swimmer.goToSwimmingPool(swimmingPool, SwimmingPoolActionOrder.CHANGING_ROOM_BEFORE_LOCKER);
            }
        };
        Runnable men2 = new Runnable() {
            public void run() {
                Swimmer swimmer = new Swimmer();
                swimmer.goToSwimmingPool(swimmingPool, SwimmingPoolActionOrder.LOCKER_BEFORE_CHANGING_ROOM);
            }
        };
        Thread thread1 = new Thread(men1);
        Thread thread2 = new Thread(men2);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
