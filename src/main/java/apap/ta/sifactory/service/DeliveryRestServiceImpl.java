package apap.ta.sifactory.service;

import apap.ta.sifactory.rest.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

@Service
@Transactional
public class DeliveryRestServiceImpl implements DeliveryRestService {
    private final WebClient webClient;

    public DeliveryRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.listAlamatSiBusiness).build();
    }

    @Override
    public Mono<String> getListIdCabang() {
        return this.webClient.get().uri("/rest/retail/getListIdCabang")
                .retrieve()
                .bodyToMono(String.class);
    }
}