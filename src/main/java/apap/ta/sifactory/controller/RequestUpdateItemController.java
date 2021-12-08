package apap.ta.sifactory.controller;

import apap.ta.sifactory.model.RequestUpdateItemModel;
import apap.ta.sifactory.rest.ItemDetail;
import apap.ta.sifactory.service.ItemRestService;
import apap.ta.sifactory.service.RequestUpdateItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/request")
public class RequestUpdateItemController {
    @Autowired
    private RequestUpdateItemService requestUpdateItemService;

    @Autowired
    private ItemRestService itemRestService;

    //Fitur 10
    @GetMapping("/list")
    public String listRequest(Model model) {
        List<RequestUpdateItemModel> listRequest = requestUpdateItemService.getAllRequest();
        List<ItemDetail> listItem = itemRestService.getAllItem();
        model.addAttribute("listRequest", listRequest);
        model.addAttribute("listItem", listItem);
        return "viewall-request-update-item";
    }
}
