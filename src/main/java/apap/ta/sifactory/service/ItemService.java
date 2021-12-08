package apap.ta.sifactory.service;

import apap.ta.sifactory.model.JenisKategori;
import apap.ta.sifactory.model.MesinModel;

import java.util.List;

public interface ItemService {
    List<JenisKategori> getKategoriItem(List<MesinModel> listMesin);
}
