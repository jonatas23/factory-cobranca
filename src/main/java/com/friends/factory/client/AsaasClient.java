package com.friends.factory.client;

import com.friends.factory.model.PaymentListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Classe Service responsável por interagir com o serviço do ASAAS externo.
 * Esta classe utiliza RestTemplate para fazer chamadas HTTP ao serviço de Vínculo.
 */
@Service
@RequiredArgsConstructor
public class AsaasClient {

    private final String BASE_URL = "https://sandbox.asaas.com/api/v3/payments";
    private final String ACCESS_TOKEN = "aact_YTU5YTE0M2M2N2I4MTliNzk0YTI5N2U5MzdjNWZmNDQ6OjAwMDAwMDAwMDAwMDAwNjM2MDY6OiRhYWNoXzdhZmU2NmZl-LWMwZGUtNDU0ZC04ZmM4LTkxZGU4MThkYTYzZQ==";

    public PaymentListResponse fetchPaymentsDueInThreeDays() {
        // Calcular a data de vencimento com 3 dias de antecedência a partir de hoje
        LocalDate today = LocalDate.now();
        LocalDate dueDate = today.plusDays(3);

        // Formatar a data no formato esperado (dd-MM-yyyy)
        String formattedDueDate = dueDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        // Construir a URL com os parâmetros
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("dueDate[ge]", formattedDueDate);

        // Criar uma instância do RestTemplate para fazer a solicitação GET
        RestTemplate restTemplate = new RestTemplate();

        // Fazer a solicitação GET
        ResponseEntity<PaymentListResponse> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                criarHttpEntity(),
                PaymentListResponse.class);

        // Você pode processar a resposta JSON aqui
        return response.getBody();
    }


    /**
     * Método para criar um HttpEntity com os cabeçalhos necessários para a chamada ao serviço externo.
     *
     * @return Um objeto HttpEntity contendo os cabeçalhos de solicitação.
     */
    private HttpEntity<String> criarHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("access_token", ACCESS_TOKEN);
        return new HttpEntity<>("parameters", headers);
    }
}
