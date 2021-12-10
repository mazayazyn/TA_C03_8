package apap.ta.sifactory.service;

import java.util.List;

import apap.ta.sifactory.model.RequestUpdateItemModel;
import apap.ta.sifactory.model.JenisKategori;
import apap.ta.sifactory.model.MesinModel;

public interface ItemService {
    RequestUpdateItemModel createRequest(RequestUpdateItemModel req);
    List<JenisKategori> getKategoriItem(List<MesinModel> listMesin);
}
