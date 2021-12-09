package apap.ta.sifactory.controller;

import apap.ta.sifactory.model.DeliveryModel;
import apap.ta.sifactory.model.PegawaiModel;
import apap.ta.sifactory.service.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    private PegawaiService pegawaiService;

    //Fitur 12
    //Daftar request update item kalo executed True ada button Buat Delivery
    @GetMapping("/assign-kurir")
            ///{id_request_update_item}")
    private String assignKurirForm(
            @PathVariable Integer id_request_update_item,
            Model model
    ) {
        //get request update item dulu, trus get si id cabang buat jadi hidden
        List<PegawaiModel> listKurir = pegawaiService.getKurir();
        for (PegawaiModel k: listKurir) {
            System.out.println(k.getNama());
        }
        model.addAttribute("listKurir",listKurir);
        model.addAttribute("id_request_update_item",id_request_update_item);
        model.addAttribute("delivery", new DeliveryModel());
        return "form-assign-kurir";
    }

    @PostMapping("/assign-kurir")
    private String assignKurirPost(
            @ModelAttribute DeliveryModel deliveryModel,
            Model model
    ) {
        //get request update item dulu, trus get si id cabang buat jadi hidden
        List<PegawaiModel> listKurir = pegawaiService.getKurir();
        for (PegawaiModel k: listKurir) {
            System.out.println(k.getNama());

        }
        model.addAttribute("listKurir",listKurir);
        model.addAttribute("id_request_update_item", 1);//id_request_update_item);
        model.addAttribute("delivery", new DeliveryModel());
        return "form-assign-kurir";
    }
}
