package apap.ta.sifactory.service;

<<<<<<< HEAD
import apap.ta.sifactory.model.JenisKategori;
import apap.ta.sifactory.rest.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
=======
import apap.ta.sifactory.rest.ListItemDetail;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
import apap.ta.sifactory.rest.Setting;
>>>>>>> f52847d92578c802686dd9775dbe2792f4fd1051

import java.util.*;

import reactor.core.publisher.Mono;
<<<<<<< HEAD
=======
import apap.ta.sifactory.rest.ItemDetail;
>>>>>>> f52847d92578c802686dd9775dbe2792f4fd1051
import apap.ta.sifactory.rest.ListItemDetail;

@Service
@Transactional
public class ItemRestServiceImpl implements ItemRestService{
    private final WebClient webClient;
<<<<<<< HEAD
    private final WebClient proposeWeb;

    public ItemRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.siItemUrl).build();
        this.proposeWeb = webClientBuilder.baseUrl(Setting.proposeUrl).build();
    }

=======

    public ItemRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.siItemUrl).build();
    }

    //Fitur 5
>>>>>>> f52847d92578c802686dd9775dbe2792f4fd1051
    @Override
    public List<ItemDetail> getAllItem() {
        ListItemDetail getSiItem = this.webClient.get().uri("/")
                .retrieve()
<<<<<<< HEAD
                .bodyToMono(ListItemDetail.class).block();
=======
                .bodyToMono(ListItemDetail.class)
                .block();
>>>>>>> f52847d92578c802686dd9775dbe2792f4fd1051
        return getSiItem.getListItem();
    }

    @Override
<<<<<<< HEAD
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
=======
    public List<String> getKategoriItem() {
//        Mono<ItemDetail> hasil = getAllItem();
//        System.out.print(hasil);
//        for (ItemDetail i:hasil) {
//            //if id kategori di mesin
//        }
        return null;
>>>>>>> f52847d92578c802686dd9775dbe2792f4fd1051
    }
}
