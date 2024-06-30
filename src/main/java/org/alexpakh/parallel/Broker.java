package org.alexpakh.parallel;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Broker {

    private static final String MESSAGE_ADD_TO_ARRAY = " send message by producer";
    private static final int ARRAY_SIZE_MAX = 10;
    boolean flag = false;

    public static Queue<String> message = new ConcurrentLinkedQueue<>() {
    };

    public synchronized void addMessage() {
        System.out.println(message.add(MESSAGE_ADD_TO_ARRAY) + " " + message.size());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (message.size() > 9) {

            try {
            notifyAll();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//            flag = true;
//        }
    }

    public synchronized void writeAndDeleteMessage() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(message.poll() + " delete " + message.size());
        while (message.isEmpty()) {

            try {
               wait();
            notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//            flag = false;
//        }
    }

    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        Thread threadProducer = new Thread(producer);
        Thread threadConsumer = new Thread(consumer);

        threadProducer.start();
        threadConsumer.start();
    }


}
