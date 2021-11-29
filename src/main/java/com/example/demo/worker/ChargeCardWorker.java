package com.example.demo.worker;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.ExternalTaskClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.awt.Desktop;
import java.net.URI;

@Slf4j
@Component
public class ChargeCardWorker implements CommandLineRunner {

    public void subscribe() {

        ExternalTaskClient client = ExternalTaskClient.create()
            .baseUrl("http://localhost:8080/engine-rest")
            .asyncResponseTimeout(10000)
            .build();

        client.subscribe("charge-car")
                .lockDuration(1000)
                .handler((externalTask, externalTaskService) -> {
                    String item = (String) externalTask.getVariable("item");
                    Long amount = 0l;
                    log.info("Approved: " + externalTask.getVariable("approved"));
                    try {
                        amount = externalTask.getVariable("amount");
                    } catch (Exception e) {
                        amount = Long.valueOf((Integer)externalTask.getVariable("amount"));
                    }

                    log.info("Charging credit card with an amount of '" + amount + "'€ for the item '" + item + "'...");
                    try {
                        Desktop.getDesktop().browse(new URI("https://globo.com"));
                    } catch (Exception e) {
                        log.error("Cannot open");
//                        e.printStackTrace();
                    }

                    externalTaskService.complete(externalTask);
                }).open();
    }

    @Override
    public void run(String... args) throws Exception {

        log.info("Subscribing");
//        subscribe();
    }
}
