package apap.ta.sifactory.service;

import apap.ta.sifactory.model.ProduksiModel;
import apap.ta.sifactory.model.RequestUpdateItemModel;

import java.util.Optional;

public interface ProduksiService {
    ProduksiModel createProduksi(ProduksiModel produksi);
    ProduksiModel createProduksiByRequest(RequestUpdateItemModel req);
    ProduksiModel getProduksiByItem(String req);
}
