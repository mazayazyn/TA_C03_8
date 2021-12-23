package apap.ta.sifactory.service;

import apap.ta.sifactory.model.ProduksiModel;
import apap.ta.sifactory.model.RequestUpdateItemModel;

import java.util.List;

public interface ProduksiService {
    ProduksiModel createProduksi(ProduksiModel produksi);
    ProduksiModel createProduksiByRequest(RequestUpdateItemModel req, Integer idMesin, String usernamePegawai);
    List<ProduksiModel> getProduksiByItem(String req);
}
