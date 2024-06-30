package org.alexpakh.parallel;


public class Consumer implements Runnable {
    Broker broker = new Broker();

    public synchronized void run() {

        while (true) {

            broker.writeAndDeleteMessage();

        }
    }
}
