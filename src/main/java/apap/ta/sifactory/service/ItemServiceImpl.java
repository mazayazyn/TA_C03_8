package apap.ta.sifactory.service;

import apap.ta.sifactory.model.JenisKategori;
import apap.ta.sifactory.model.MesinModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{


    @Override
    public List<JenisKategori> getKategoriItem(List<MesinModel> listMesin) {
        List<JenisKategori> listKategori = new ArrayList<>();
        for (MesinModel m:listMesin) {
            JenisKategori kategori = JenisKategori.values()[m.getId_kategori()-1];
            if(!listKategori.contains(kategori)){
                listKategori.add(kategori);
            }
        }
        return listKategori;
    }
}
