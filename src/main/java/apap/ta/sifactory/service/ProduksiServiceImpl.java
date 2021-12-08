package apap.ta.sifactory.service;

import apap.ta.sifactory.model.ProduksiModel;
import apap.ta.sifactory.model.RequestUpdateItemModel;
import apap.ta.sifactory.repository.PegawaiDB;
import apap.ta.sifactory.repository.ProduksiDB;
import apap.ta.sifactory.repository.RequestUpdateItemDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

        produksi.setId_kategori(produksiBaru.getId_kategori());
        produksi.setId_request_update_item(null);
        produksi.setTambahan_stok(produksiBaru.getTambahan_stok());
        produksi.setTanggal_produksi(produksiBaru.getTanggal_produksi());
        produksi.setMesin(produksiBaru.getMesin());
        produksi.setPegawai(pegawaiDB.findByUsername(authentication.getName()));
        produksi.setId_item(produksiBaru.getId_item());

        return produksiDB.save(produksi);
    }

    @Override
    public ProduksiModel createProduksiByRequest(RequestUpdateItemModel req) {
        ProduksiModel produksi = new ProduksiModel();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getAuthorities());

        produksi.setId_kategori(req.getId_kategori());
        produksi.setId_request_update_item(req.getId_request_update_item());
        produksi.setTambahan_stok(req.getTambahan_stok());
        produksi.setTanggal_produksi(req.getTanggal_request());
        produksi.setMesin(null);
        produksi.setPegawai(pegawaiDB.findByUsername(authentication.getName()));
        produksi.setId_item(req.getId_item());

        return produksiDB.save(produksi);
    }
}
