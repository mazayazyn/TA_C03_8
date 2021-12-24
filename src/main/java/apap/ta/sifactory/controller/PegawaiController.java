package apap.ta.sifactory.controller;

import apap.ta.sifactory.model.PegawaiModel;
import apap.ta.sifactory.model.RoleModel;
import apap.ta.sifactory.service.PegawaiService;
import apap.ta.sifactory.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@Controller
@RequestMapping("/pegawai")
public class PegawaiController {
    @Autowired
    private PegawaiService pegawaiService;

    @Autowired
    private RoleService roleService;

    //Fitur 16
    @GetMapping("/add-pegawai")
    private String addPegawaiForm(Model model) {
        PegawaiModel user = new PegawaiModel();
        List<RoleModel> listRole = roleService.getListRole();
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-pegawai";
    }

    //Fitur 16
    @PostMapping(value = "/add-pegawai")
    private String addPegawaiSubmit(@ModelAttribute PegawaiModel pegawai, Model model) {
        if(pegawaiService.getPegawai(pegawai.getUsername())!=null){//pegawai yang ingin ditambah ada username sama
            model.addAttribute("page", "menambah");
            model.addAttribute("tipe", "akun pengguna/pegawai");
            model.addAttribute("cause", "username sudah digunakan");
            return "error-page";
        }
        pegawai.setCounter(0);
        pegawaiService.addPegawai(pegawai);
        String nama = SecurityContextHolder.getContext().getAuthentication().getName();//get pegawai yang input
        pegawaiService.addCounterPegawai(nama);
        model.addAttribute("action", "menambah");
        model.addAttribute("tipe", "akun pengguna/pegawai baru");
        return "success-page";
    }

    //Fitur 17
    @GetMapping(value = "/daftar-pegawai")
    public String viewAllPegawai(
            Model model
    ){
        List<PegawaiModel> listPegawai = pegawaiService.getDaftarPegawai();
        String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
        model.addAttribute("role", role);
        model.addAttribute("listPegawai", listPegawai);
        return "list-pegawai";
    }

}