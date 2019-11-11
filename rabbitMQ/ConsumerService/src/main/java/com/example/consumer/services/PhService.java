package com.example.consumer.services;

import com.example.consumer.model.Ph;
import com.example.consumer.utilities.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PhService {

    private static final Logger log = LoggerFactory.getLogger(PhService.class);

    @RabbitListener(queues = "ph.queue")
    public Ph retrievePhData(Ph ph) {

        if (ph.getPh() != Constants.PH_NEUTRO) {
            log.error("ATTENZIONE! Valore {} fuori norma: reimpostare il PH", ph.getPh());
        } else {
            System.out.println("PH corretto: " + ph.getPh());
        }

        return null;
    };
}
