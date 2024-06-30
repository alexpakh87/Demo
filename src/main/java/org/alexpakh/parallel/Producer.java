package org.alexpakh.parallel;

public class Producer implements Runnable {


    Broker broker = new Broker();

    public void run() {
        while (true) {

            broker.addMessage();


        }

    }
}

