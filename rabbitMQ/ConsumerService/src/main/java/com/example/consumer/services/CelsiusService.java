package com.example.consumer.services;

import com.example.consumer.model.Celsius;
import com.example.consumer.utilities.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CelsiusService {

    private static final Logger log = LoggerFactory.getLogger(CelsiusService.class);

    @RabbitListener(queues = "celsius.queue")
    public Celsius retrieveCelsiusData(Celsius celsius) throws Exception {

        System.out.println("Temperatura generata: " + celsius.getDegree());

        if (celsius.getDegree() < Constants.CELSIUS_MIN_RANGE || celsius.getDegree() > Constants.CELSIUS_MAX_RANGE) {
            log.error("ATTENZIONE! Valore {} fuori norma: reimpostare la temperatura", celsius.getDegree());
        } else {
            System.out.println("Temperatura impostata correttamente: " + celsius.getDegree());
        }

        return null;
    }
}
