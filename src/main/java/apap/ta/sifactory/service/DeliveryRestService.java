package apap.ta.sifactory.service;

import reactor.core.publisher.Mono;

import java.util.List;

public interface DeliveryRestService {
    Mono<String> getListIdCabang();
}
