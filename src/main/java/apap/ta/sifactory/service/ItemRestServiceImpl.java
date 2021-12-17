package apap.ta.sifactory.service;

import apap.ta.sifactory.model.JenisKategori;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import apap.ta.sifactory.rest.ListItemDetail;

import javax.transaction.Transactional;
import apap.ta.sifactory.rest.Setting;
import java.util.*;
import apap.ta.sifactory.rest.GetItem;
import apap.ta.sifactory.rest.ItemDetail;

@Service
@Transactional
public class ItemRestServiceImpl implements ItemRestService{
    private final WebClient webClient;
    private final WebClient siBusinessWeb;

    public ItemRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.siItemUrl).build();
        this.siBusinessWeb = webClientBuilder.baseUrl(Setting.siBusinessUrl).build();
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

    //Fitur 4 dan 6
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

    //Fitur 4
    @Override
    public List<String> getKategoriItem() {
//        Mono<ItemDetail> hasil = getAllItem();
//        System.out.print(hasil);
//        for (ItemDetail i:hasil) {
//            //if id kategori di mesin
//        }
        return null;
    }

    public String postProposeItem(ItemDetail proposeItem) {
        Integer kategori = JenisKategori.valueOf(proposeItem.getKategori()).ordinal()+1;
        Map<String, Object> data = new HashMap<>();
        data.put("name", proposeItem.getNama());
        data.put("stock", proposeItem.getStok());
        data.put("price", proposeItem.getHarga());
        data.put("category", kategori);
        String hasil = this.siBusinessWeb.post().uri("/api/v1/item/propose")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.ALL)
                .syncBody(data)
                .retrieve()
                .bodyToMono(String.class).block();
        System.out.println("hasil");
        System.out.println(hasil);

        hasil = hasil.substring(1, hasil.length()-1);
        System.out.println(hasil);
        String getStatus = hasil.split(",")[1];   //split to get response status
        System.out.println(getStatus);
        String statusCode = getStatus.split(":")[1];
        System.out.println(statusCode);

        return statusCode;
    }

}
