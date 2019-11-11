
package com.example.producer;

import com.example.producer.model.Celsius;
import com.example.producer.model.Ph;
import com.example.producer.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Override
    public void run(String...args) throws Exception {

        int celsiusMin = 10;
        int celsiusMax = 50;
        int phMin = -7;
        int phMax = 7;

        try {
            while (true) {
                Random r = new Random();

                double celsius = r.nextInt((celsiusMax - celsiusMin) + 1) + celsiusMin;
                System.out.println("Temperatura generata: " + celsius);
                rabbitMQSender.sendCelsius(new Celsius("celsius-"+celsius, celsius, new Date()));

                double ph = r.nextInt((phMax - phMin) + 1) + phMin;
                System.out.println("PH generato: " + ph);
                rabbitMQSender.sendPh(new Ph("ph-"+ph, ph, new Date()));
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
