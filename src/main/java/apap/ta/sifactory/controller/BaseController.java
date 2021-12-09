package apap.ta.sifactory.controller;

import apap.ta.sifactory.model.PegawaiModel;
import apap.ta.sifactory.repository.PegawaiDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class BaseController {
    @Autowired
    private PegawaiDB pegawaiDB;

    @RequestMapping("/")
    private String home(Model model, @AuthenticationPrincipal UserDetails currentUser) {
//        PegawaiModel pegawai = (PegawaiModel) pegawaiDB.findByUsername(currentUser.getUsername());
//        model.addAttribute("currentPegawai", pegawai);
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

//    @GetMapping("/factorymanager")
//    public String homeFactoryManager(Model model) {
//        return "home-factory-manager";
//    }
//
//    @GetMapping("/admin")
//    public String homeAdmin(Model model) {
//        return "home";
//    }
//
//    @GetMapping("/gudang")
//    public String homeStaffGudang(Model model) {
//        return "home-staff-gudang";
//    }
//
//    @GetMapping("/operasional")
//    public String homeStaffOperasional(Model model) {
//        return"home-staff-operasional";
//    }
//
//    @GetMapping("/kurir")
//    public String homeStaffKurir(Model model) {
//        return"home-staff-kurir";
//    }
}