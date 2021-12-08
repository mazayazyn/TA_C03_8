package apap.ta.sifactory.service;

import apap.ta.sifactory.rest.ItemDetail;
import apap.ta.sifactory.rest.ProposeItemDetail;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ItemRestService {
    List<ItemDetail> getAllItem();
    String postProposeItem(ItemDetail proposeItem);
}
