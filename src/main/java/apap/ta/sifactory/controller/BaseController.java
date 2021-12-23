package apap.ta.sifactory.controller;

import apap.ta.sifactory.model.PegawaiModel;
import apap.ta.sifactory.model.ProduksiModel;
import apap.ta.sifactory.repository.PegawaiDB;
import apap.ta.sifactory.repository.ProduksiDB;
import apap.ta.sifactory.rest.ItemDetail;
import apap.ta.sifactory.service.ItemRestService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
    @Autowired
    private PegawaiDB pegawaiDB;

    @Autowired
    private ProduksiDB produksiDB;

    @Autowired
    private ItemRestService itemRestService;

    @RequestMapping("/")
    private String home(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        PegawaiModel pegawai = (PegawaiModel) pegawaiDB.findByUsername(currentUser.getUsername());
        model.addAttribute("currentPegawai", pegawai);
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/produksi/daftar-produksi")
    public String listItem(Model model) {
        List<ProduksiModel> listProduksi = produksiDB.findAll();
        List<String> listItemSaring = new ArrayList<>();
        List<String> listKategoriSaring = new ArrayList<>();
        List<String> list = Arrays.asList("BUKU", "DAPUR","MAKANAN & MINUMAN","ELEKTRONIK","FASHION","KECANTIKAN & PERAWATAN DIRI","FILM & MUSIK","GAMING","GADGET","KESEHATAN","RUMAH TANGGA","FURNITURE","ALAT & PERANGKAT KERAS","WEDDING");

        for (int i = 0; i < list.size(); i++) {
            
        }
        for (int i = 0; i < listProduksi.size(); i++) {
            listItemSaring.add(itemRestService.getItemByUUID(listProduksi.get(i).getIdItem()).getNama());
            listKategoriSaring.add(itemRestService.getItemByUUID(listProduksi.get(i).getIdItem()).getKategori());


        }

        model.addAttribute("listProduksi", listProduksi);
        model.addAttribute("listItemSaring", listItemSaring);
        model.addAttribute("listKategoriSaring", listKategoriSaring);
        return "list-produksi";
    }
}