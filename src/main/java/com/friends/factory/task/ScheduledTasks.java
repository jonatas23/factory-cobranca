package com.friends.factory.task;

import com.friends.factory.model.PaymentListResponse;
import com.friends.factory.service.AsaasService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ScheduledTasks {

    public static final String URL = "";
    private final AsaasService asaasService;

    @Scheduled(cron = "0 0 10 * * *", zone = "America/Sao_Paulo")
    public void fetchPaymentsDueInThreeDays() {
        log.info("*************** Scheduled fetchPaymentsDueInThreeDays ***************");
        this.asaasService.fetchPaymentsDueInThreeDays();
    }

}
