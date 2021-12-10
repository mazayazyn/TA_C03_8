package apap.ta.sifactory.service;

import apap.ta.sifactory.model.JenisKategori;
import apap.ta.sifactory.model.MesinModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RequestUpdateItemDB requestUpdateItemDB;

    @Autowired
    private ProduksiService produksiService;

    @Override
    public RequestUpdateItemModel createRequest(RequestUpdateItemModel req) {
        //create produksi
        produksiService.createProduksiByRequest(req);
        //set produksi
        //set delivery

        return requestUpdateItemDB.save(req);
    }

    @Override
    public List<JenisKategori> getKategoriItem(List<MesinModel> listMesin) {
        List<JenisKategori> listKategori = new ArrayList<>();
        for (MesinModel m:listMesin) {
            JenisKategori kategori = JenisKategori.values()[m.getIdKategori()-1];
            if(!listKategori.contains(kategori)){
                listKategori.add(kategori);
            }
        }
        return listKategori;
    }


}
