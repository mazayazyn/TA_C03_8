package apap.ta.sifactory.service;

<<<<<<< HEAD
import apap.ta.sifactory.rest.ItemDetail;
import apap.ta.sifactory.rest.ProposeItemDetail;
=======
import apap.ta.sifactory.rest.ListItemDetail;
import apap.ta.sifactory.rest.ItemDetail;
>>>>>>> f52847d92578c802686dd9775dbe2792f4fd1051
import reactor.core.publisher.Mono;

import java.util.List;

public interface ItemRestService {
    List<ItemDetail> getAllItem();
<<<<<<< HEAD
    String postProposeItem(ItemDetail proposeItem);
=======
    List<String> getKategoriItem();
>>>>>>> f52847d92578c802686dd9775dbe2792f4fd1051
}
