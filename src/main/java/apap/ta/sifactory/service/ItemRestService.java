package apap.ta.sifactory.service;

import apap.ta.sifactory.rest.ItemDetail;
import java.util.List;

public interface ItemRestService {
    List<ItemDetail> getAllItem();
    List<String> getKategoriItem();
    ItemDetail getItemByUUID(String uuid);
    String postProposeItem(ItemDetail proposeItem);
}
