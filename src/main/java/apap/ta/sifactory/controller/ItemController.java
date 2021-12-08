package apap.ta.sifactory.controller;

import apap.ta.sifactory.rest.ItemDetail;
import apap.ta.sifactory.service.ItemRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemRestService itemRestService;

    //Fitur 5
    @GetMapping("/listItem")
    public String listItem(Model model) {
        List<ItemDetail> listItem = itemRestService.getAllItem();
        model.addAttribute("listItem", listItem);
        return "viewall-item";
    }
}
