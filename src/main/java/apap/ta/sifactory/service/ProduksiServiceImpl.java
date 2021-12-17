package apap.ta.sifactory.service;

import apap.ta.sifactory.model.MesinModel;
import apap.ta.sifactory.model.ProduksiModel;
import apap.ta.sifactory.model.RequestUpdateItemModel;
import apap.ta.sifactory.repository.PegawaiDB;
import apap.ta.sifactory.repository.ProduksiDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class ProduksiServiceImpl implements ProduksiService {

    @Autowired
    private ProduksiDB produksiDB;

    @Autowired
    private PegawaiDB pegawaiDB;

    @Override
    public ProduksiModel createProduksi(ProduksiModel produksiBaru) {
        ProduksiModel produksi = new ProduksiModel();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        produksi.setIdKategori(produksiBaru.getIdKategori());
//        produksi.setIdRequestUpdateItem(null);
        produksi.setTambahanStok(produksiBaru.getTambahanStok());
        produksi.setTanggalProduksi(produksiBaru.getTanggalProduksi());
        produksi.setMesin(produksiBaru.getMesin());
        produksi.setPegawai(pegawaiDB.findByUsername(authentication.getName()));
        produksi.setIdItem(produksiBaru.getIdItem());

        return produksiDB.save(produksi);
    }

    @Override
    public ProduksiModel createProduksiByRequest(RequestUpdateItemModel req) {
        ProduksiModel produksi = new ProduksiModel();

        produksi.setIdKategori(req.getIdKategori());
//        produksi.setIdRequestUpdateItem(req.getIdRequestUpdateItem());
        produksi.setTambahanStok(req.getTambahanStok());
        produksi.setTanggalProduksi(req.getTanggalRequest());
        produksi.setMesin(null);
        produksi.setIdItem(req.getIdItem());

        return produksiDB.save(produksi);
    }

    @Override
    public ProduksiModel getProduksiByItem(String req) {
        Optional<ProduksiModel> produksi = produksiDB.findByIdItem(req);
        if (produksi.isPresent()) {
            System.out.println("hjuh");
            return produksi.get();
        }
        System.out.println("huh");
        return null;
    }

}
