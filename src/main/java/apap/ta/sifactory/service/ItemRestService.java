package apap.ta.sifactory.service;

import apap.ta.sifactory.model.RequestUpdateItemModel;
import apap.ta.sifactory.rest.ItemDetail;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface ItemRestService {
    List<ItemDetail> getAllItem();
    List<String> getKategoriItem();
    List<ItemDetail> getListKategori(Integer idKategori);
    ItemDetail getItemByUUID(String uuid);
    String postProposeItem(ItemDetail proposeItem);
    HttpStatus executeUpdateByRequest(RequestUpdateItemModel req, ItemDetail item);
}
