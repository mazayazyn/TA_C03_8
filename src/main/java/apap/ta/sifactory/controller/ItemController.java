package apap.ta.sifactory.controller;

import apap.ta.sifactory.model.ProduksiModel;
import apap.ta.sifactory.rest.ItemDetail;
import apap.ta.sifactory.service.ItemRestService;
import apap.ta.sifactory.service.ProduksiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemRestService itemRestService;

    @Autowired
    private ProduksiService produksiService;

    //Fitur 5
    @GetMapping("/listItem")
    public String listItem(Model model) {
        List<ItemDetail> listItem = itemRestService.getAllItem();
        model.addAttribute("listItem", listItem);
        return "viewall-item";
    }

    //Fitur 7
    @GetMapping("/item/update/{uuid}")
    public String getFormUpdateItem(
        @PathVariable String uuid,
        Model model
    ) {
        ItemDetail item = itemRestService.getItemByUUID(uuid);
        model.addAttribute("item",item);
        return "form-update-item";
    }

    //Fitur 7
    @PostMapping("/item/update/")
    public String postFormUpdateItem(
        Model model,
        @ModelAttribute ProduksiModel produksi
    ) {
        produksiService.createProduksi(produksi);
        model.addAttribute("produksi", "produksi");
        return "respon-update-item";
    }

}
