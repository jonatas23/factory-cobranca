package com.friends.factory.service;

import com.friends.factory.client.AsaasClient;
import com.friends.factory.model.PaymentListResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AsaasService {

    private final AsaasClient asaasClient;

    public void fetchPaymentsDueInThreeDays() {
        log.info("*************** Service fetchPaymentsDueInThreeDays ***************");
        PaymentListResponse listaCobranca = this.asaasClient.fetchPaymentsDueInThreeDays();
    }
}
