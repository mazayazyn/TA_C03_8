package apap.ta.sifactory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BaseController {

    @GetMapping("/factorymanager")
    public String homeFactoryManager(Model model) {
        return "home-factory-manager";
    }

    @GetMapping("/admin")
    public String homeAdmin(Model model) {
        return "home-admin";
    }

    @GetMapping("/gudang")
    public String homeStaffGudang(Model model) {
        return "home-staff-gudang";
    }

    @GetMapping("/operasional")
    public String homeStaffOperasional(Model model) {
        return"home-staff-operasional";
    }

    @GetMapping("/kurir")
    public String homeStaffKurir(Model model) {
        return"home-staff-kurir";
    }
}