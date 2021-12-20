package apap.ta.sifactory.service;

import java.util.List;

import apap.ta.sifactory.model.MesinModel;

public interface MesinService {
    List<MesinModel> getAllMesin();
    List<MesinModel> getAllMesinByKategoriItem(String kategori);
    MesinModel getMesinByIdMesin(Integer idMesin);
    MesinModel getNamaMesinByIdMesin(Integer idMesin);
}