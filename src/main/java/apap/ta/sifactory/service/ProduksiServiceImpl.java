package apap.ta.sifactory.service;

import apap.ta.sifactory.model.ProduksiModel;
import apap.ta.sifactory.model.RequestUpdateItemModel;
import apap.ta.sifactory.repository.PegawaiDB;
import apap.ta.sifactory.repository.ProduksiDB;
import apap.ta.sifactory.repository.RequestUpdateItemDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import apap.ta.sifactory.repository.ProduksiDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

        //baru byname
        produksi.setIdKategori(produksiBaru.getIdKategori());
        produksi.setIdRequestUpdateItem(null);
        //input user
        produksi.setTambahanStok(produksiBaru.getTambahanStok());
        //tanggal sekarang
        produksi.setTanggalProduksi(produksiBaru.getTanggalProduksi());
        //input user
        produksi.setMesin(produksiBaru.getMesin());
        produksi.setPegawai(pegawaiDB.findByUsername(authentication.getName()));
        //uuid
        produksi.setIdItem(produksiBaru.getIdItem());

        return produksiDB.save(produksi);
    }

    @Override
    public ProduksiModel createProduksiByRequest(RequestUpdateItemModel req) {
        ProduksiModel produksi = new ProduksiModel();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);

        produksi.setIdKategori(req.getIdKategori());
        //blm ada id gmn caranya
        produksi.setIdRequestUpdateItem(req.getIdRequestUpdateItem());
        produksi.setTambahanStok(req.getTambahanStok());
        produksi.setTanggalProduksi(req.getTanggalRequest());
        produksi.setMesin(null);
        // produksi.setPegawai(pegawaiDB.findByUsername(authentication.getName()));
        produksi.setIdItem(req.getIdItem());

        return produksiDB.save(produksi);
    }
}
