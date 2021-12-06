package apap.ta.sifactory.service;

import apap.ta.sifactory.rest.ListItemDetail;
import apap.ta.sifactory.rest.ItemDetail;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ItemRestService {
    List<ItemDetail> getAllItem();
    List<String> getKategoriItem();
}
