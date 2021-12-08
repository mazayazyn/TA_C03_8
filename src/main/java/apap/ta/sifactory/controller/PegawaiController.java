package apap.ta.sifactory.controller;

import apap.ta.sifactory.model.PegawaiModel;
import apap.ta.sifactory.model.RoleModel;
import apap.ta.sifactory.service.PegawaiService;
import apap.ta.sifactory.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PegawaiController {
    @Autowired
    private PegawaiService pegawaiService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/add-pegawai")
    private String addPegawaiForm(Model model) {
        PegawaiModel user = new PegawaiModel();
        List<RoleModel> listRole = roleService.getListRole();
        for (RoleModel role : listRole) {
            System.out.println(role.getNama_role());
        }
        model.addAttribute("user", user);
        model.addAttribute("listRole", listRole);
        return "form-add-pegawai";
    }

    @PostMapping(value = "/add-pegawai")
    private String addPegawaiSubmit(@ModelAttribute PegawaiModel pegawai, Model model) {
        pegawai.setCounter(0);
        pegawaiService.addPegawai(pegawai);
        model.addAttribute("pegawai", pegawai);
        return "redirect:/";
    }

}