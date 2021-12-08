package apap.ta.sifactory.service;

import apap.ta.sifactory.model.ProduksiModel;
import apap.ta.sifactory.model.RequestUpdateItemModel;

public interface ProduksiService {
    ProduksiModel createProduksi(ProduksiModel produksi);
    ProduksiModel createProduksiByRequest(RequestUpdateItemModel req);
}
