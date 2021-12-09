package apap.ta.sifactory.controller;

import apap.ta.sifactory.model.JenisKategori;
import apap.ta.sifactory.model.MesinModel;
import apap.ta.sifactory.rest.ItemDetail;
import apap.ta.sifactory.service.ItemRestService;
import apap.ta.sifactory.service.ItemService;
import apap.ta.sifactory.service.MesinService;
import apap.ta.sifactory.service.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private MesinService mesinService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRestService itemRestService;

    @Autowired
    private PegawaiService pegawaiService;

    //Fitur 4
    @GetMapping("/propose-item")
    private String proposeItemForm(Model model) {
        ItemDetail proposeItem = new ItemDetail();
        List<MesinModel> listMesin = mesinService.getAllMesin();
        List<JenisKategori> listKategori = itemService.getKategoriItem(listMesin);
        model.addAttribute("listKategori", listKategori);
        model.addAttribute("proposeItem", proposeItem);
        return "form-propose-item";
    }

    @PostMapping("/propose-item")
    private String proposeItemPost(@ModelAttribute ItemDetail proposeItem, Model model) {
        //manggil servicenya sibusiness
        String responsePropose = itemRestService.postProposeItem(proposeItem);
        if (responsePropose.equals("Propose item success")) {
            model.addAttribute("action", "propose");
            model.addAttribute("tipe", "item");
        } else {
            model.addAttribute("page", "propose");
            model.addAttribute("tipe", "item");
            model.addAttribute("cause", "item tidak berhasil disampaikan ke SI-BUSINESS");
            return "error-page";
        }
        String nama = SecurityContextHolder.getContext().getAuthentication().getName();//get pegawai yang input
        pegawaiService.addCounterPegawai(nama);
        return "success-page";
    }

    //Fitur 5
    @GetMapping("/listItem")
    public String listItem(Model model) {
        List<ItemDetail> listItem = itemRestService.getAllItem();
        model.addAttribute("listItem", listItem);
        return "viewall-item";
    }
}
