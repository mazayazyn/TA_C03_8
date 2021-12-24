package apap.ta.sifactory.service;

import apap.ta.sifactory.model.JenisKategori;
import apap.ta.sifactory.model.RequestUpdateItemModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import apap.ta.sifactory.rest.ListItemDetail;

import javax.transaction.Transactional;
import apap.ta.sifactory.rest.Setting;
import apap.ta.sifactory.rest.StokDetail;

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

    //Fitur 11
    @Override
    public List<ItemDetail> getListKategori(Integer idKategori) {
        String id_kategori = "/kategori/" + idKategori;
        ListItemDetail getSiItem = this.webClient.get().uri(id_kategori)
                .retrieve()
                .bodyToMono(ListItemDetail.class)
                .block();
        return getSiItem.getListItem();
    }


    @Override
    public StokDetail updateItem(String uuid, Integer tambahanStok, Integer stokItem) {
        HashMap data = new HashMap();
        data.put("stok", tambahanStok+stokItem);

        String uuid_item = "/" + uuid;
        StokDetail postItem = this.webClient.put().uri(uuid_item)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.ALL)
                .syncBody(data)
                .retrieve()
                .bodyToMono(StokDetail.class).block();
                
        return postItem;
    }

    //Fitur 6
    @Override
    public ItemDetail getItemByUUID(String uuid) {
        String uuid_dicari = "/" + uuid;
        GetItem getSiItem = this.webClient.get().uri(uuid_dicari)
                .retrieve()
                .bodyToMono(GetItem.class)
                .block();
        return getSiItem.getItem();
    }

    //Fitur 4
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

        hasil = hasil.substring(1, hasil.length()-1);
        String getStatus = hasil.split(",")[1];   //split to get response status
        String statusCode = getStatus.split(":")[1];

        return statusCode;
    }

    //Fitur 11
    @Override
    public HttpStatus executeUpdateByRequest(RequestUpdateItemModel req, ItemDetail item) {
        Integer stokTambahan = item.getStok() + req.getTambahanStok();
        Map<String, Object> data = new HashMap<>();
        data.put("nama", item.getNama());
        data.put("harga", item.getHarga());
        data.put("stok", stokTambahan);
        data.put("kategori", item.getKategori());

        return Optional.of(this.webClient.put().uri("/" + item.getUuid()).body(BodyInserters.fromValue(data)).retrieve().toBodilessEntity().block().getStatusCode()).get(); //put ke web service dan get hasil nya (status code)
    }

}
