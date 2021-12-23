package apap.ta.sifactory.controller;

import apap.ta.sifactory.model.PegawaiModel;
import apap.ta.sifactory.model.ProduksiModel;
import apap.ta.sifactory.repository.PegawaiDB;
import apap.ta.sifactory.repository.ProduksiDB;

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
        model.addAttribute("listProduksi", listProduksi);
        return "list-produksi";
    }
}