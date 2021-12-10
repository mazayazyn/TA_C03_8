package apap.ta.sifactory.service;

import reactor.core.publisher.Mono;


public interface DeliveryRestService {
    Mono<String> getListIdCabang();
}
