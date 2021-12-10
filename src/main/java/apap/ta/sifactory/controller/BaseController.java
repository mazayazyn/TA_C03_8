package apap.ta.sifactory.controller;

import apap.ta.sifactory.model.PegawaiModel;
import apap.ta.sifactory.repository.PegawaiDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseController {
    @Autowired
    private PegawaiDB pegawaiDB;

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
}