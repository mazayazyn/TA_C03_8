package apap.ta.sifactory.service;

import apap.ta.sifactory.model.JenisKategori;
import apap.ta.sifactory.rest.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import apap.ta.sifactory.rest.ListItemDetail;

import javax.transaction.Transactional;
import apap.ta.sifactory.rest.Setting;

import java.util.*;

import reactor.core.publisher.Mono;
import apap.ta.sifactory.rest.ItemDetail;
import apap.ta.sifactory.rest.ListItemDetail;

@Service
@Transactional
public class ItemRestServiceImpl implements ItemRestService{
    private final WebClient webClient;
    private final WebClient proposeWeb;

    public ItemRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.siItemUrl).build();
        this.proposeWeb = webClientBuilder.baseUrl(Setting.proposeUrl).build();
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

    //Fitur 4
    @Override
    public String postProposeItem(ItemDetail proposeItem) {
        Integer kategori = JenisKategori.valueOf(proposeItem.getKategori()).ordinal()+1;
        Map<String, Object> data = new HashMap<>();
//        data.put("id", proposeItem.getUuid());
        data.put("name", proposeItem.getNama());
        data.put("status", 0);
        data.put("stock", proposeItem.getStok());
        data.put("price", proposeItem.getHarga());
        data.put("category", kategori);
        data.put("cluster","C03");
        String hasil = this.proposeWeb.post().uri("/api/v1/item/propose")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.ALL)
                .syncBody(data)
                .retrieve()
                .bodyToMono(String.class).block();
        System.out.println("hasil");
        System.out.println(hasil);
        return this.proposeWeb.post().uri("/api/v1/item/propose")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.ALL)
                .syncBody(data)
                .retrieve()
                .bodyToMono(String.class).block();
//                this.proposeWeb.post().uri("/api/v1/item/propose")
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(Mono.just(proposeItem), ItemDetail.class)
//                .retrieve()
//                .bodyToMono(ItemDetail.class).block();
    }
}
