package apap.ta.sifactory.service;

import apap.ta.sifactory.rest.ListItemDetail;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
import apap.ta.sifactory.rest.Setting;

import java.util.*;

import reactor.core.publisher.Mono;
import apap.ta.sifactory.rest.GetItem;
import apap.ta.sifactory.rest.ItemDetail;
import apap.ta.sifactory.rest.ListItemDetail;

@Service
@Transactional
public class ItemRestServiceImpl implements ItemRestService{
    private final WebClient webClient;

    public ItemRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.siItemUrl).build();
    }

    //Fitur 5
    @Override
    public List<ItemDetail> getAllItem() {
        ListItemDetail getSiItem = this.webClient.get().uri("/")
                .retrieve()
                .bodyToMono(ListItemDetail.class)
                .block();
        return getSiItem.getListItem();
    }

    @Override
    public ItemDetail getItemByUUID(String uuid) {
        String uuid_dicari = "/" + uuid;
        System.out.print(uuid_dicari);
        GetItem getSiItem = this.webClient.get().uri(uuid_dicari)
                .retrieve()
                .bodyToMono(GetItem.class)
                .block();
        System.out.print(getSiItem);
        return getSiItem.getItem();
    }

    @Override
    public List<String> getKategoriItem() {
//        Mono<ItemDetail> hasil = getAllItem();
//        System.out.print(hasil);
//        for (ItemDetail i:hasil) {
//            //if id kategori di mesin
//        }
        return null;
    }
}
