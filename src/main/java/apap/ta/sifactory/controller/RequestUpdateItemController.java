package apap.ta.sifactory.controller;

import apap.ta.sifactory.model.*;
import apap.ta.sifactory.repository.RequestUpdateItemDB;
import apap.ta.sifactory.rest.ItemDetail;
import apap.ta.sifactory.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/request")
public class RequestUpdateItemController {
    @Autowired
    private RequestUpdateItemService requestUpdateItemService;

    @Autowired
    private ItemRestService itemRestService;

    @Autowired
    private MesinService mesinService;

    @Autowired
    private ProduksiService produksiService;

    @Autowired
    private PegawaiService pegawaiService;

    @Autowired
    private RequestUpdateItemDB requestUpdateItemDB;

    //Fitur 10
    @GetMapping("/daftar-request")
    public String listRequest(Model model) {
        List<RequestUpdateItemModel> listRequest = requestUpdateItemService.getAllRequest();
        List<ItemDetail> listItem = itemRestService.getAllItem();
        model.addAttribute("listRequest", listRequest);
        model.addAttribute("listItem", listItem);
        return "list-request-update-item";
    }

    //Fitur 11
    @GetMapping("/updateItemByRequest/{id}")
    public String updateItemByRequestForm(
            @PathVariable Integer id,
            Model model
    ) {
        RequestUpdateItemModel requestUpdateItem = requestUpdateItemService.getRequestById(id);
        ItemDetail item = itemRestService.getItemByUUID(requestUpdateItem.getIdItem());
        String namaItem = item.getNama();
        List<MesinModel> listMesin = mesinService.getAllMesinByKategoriItem(item.getKategori());
        model.addAttribute("requestUpdateItem", requestUpdateItem);
        model.addAttribute("idRequest", requestUpdateItem.getIdRequestUpdateItem());
        model.addAttribute("namaItem", namaItem);
        model.addAttribute("listMesin", listMesin);
        return "form-update-item-by-request";
    }

    //Fitur 11
    @PostMapping("/updateItemByRequest/{id}")
    public String updateItemByRequestSubmit(
            @PathVariable Integer id,
            Model model,
            @ModelAttribute RequestUpdateItemModel requestUpdateItem,
            @RequestParam("mesin") Integer idMesin
    ) {

        String usernamePegawai = SecurityContextHolder.getContext().getAuthentication().getName();//get pegawai yang input
        ItemDetail item = itemRestService.getItemByUUID(requestUpdateItem.getIdItem());
        HttpStatus status = itemRestService.executeUpdateByRequest(requestUpdateItem, item);
        String namaItem = item.getNama();

        if(status.is2xxSuccessful()) {
            pegawaiService.addCounterPegawai(usernamePegawai);
            ProduksiModel produksi = produksiService.createProduksiByRequest(requestUpdateItem, idMesin, usernamePegawai);
            requestUpdateItem.setExecuted(true);
            requestUpdateItemDB.save(requestUpdateItem);
            model.addAttribute("action", "update stok item berdasarkan request");
            model.addAttribute("tipe", "item '" + namaItem + "'. Produksi untuk stok tambahan akan dijalankan.");
            model.addAttribute("url", "/request/daftar-request");
            model.addAttribute("pageTitle", "Daftar Request");
            return "success-page-update";
        } else {
            model.addAttribute("message", "update stok item berdasarkan request untuk item '" + namaItem + "' gagal diproses.");
            model.addAttribute("url", "/request/daftar-request");
            model.addAttribute("pageTitle", "Daftar Request");
            return "error-page-update";
        }
    }

}
