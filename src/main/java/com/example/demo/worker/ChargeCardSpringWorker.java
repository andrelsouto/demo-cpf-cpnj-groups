package com.example.demo.worker;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Component;

import java.awt.Desktop;
import java.net.URI;

@Component
@ExternalTaskSubscription("charge-car")
@Slf4j
public class ChargeCardSpringWorker implements ExternalTaskHandler {

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        String item = (String) externalTask.getVariable("item");
        Long amount = 0l;
        log.info("Approved: {}", (Boolean) externalTask.getVariable("approved"));
        try {
            amount = externalTask.getVariable("amount");
        } catch (Exception e) {
            amount = Long.valueOf((Integer)externalTask.getVariable("amount"));
        }

        log.info("Charging credit card with an amount of '{}'€ for the item '{}'...", amount, item);
        try {
            Desktop.getDesktop().browse(new URI("https://globo.com"));
        } catch (Exception e) {
            log.error("Cannot open");
//                        e.printStackTrace();
        }

        externalTaskService.complete(externalTask);
    }
}
