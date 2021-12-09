package apap.ta.sifactory.service;

import apap.ta.sifactory.model.ProduksiModel;
import apap.ta.sifactory.repository.ProduksiDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProduksiServiceImpl implements ProduksiService {
    @Autowired
    private ProduksiDB produksiDB;

    @Override
    public ProduksiModel createProduksi(ProduksiModel produksi) {
        return produksiDB.save(produksi);
    }
}
