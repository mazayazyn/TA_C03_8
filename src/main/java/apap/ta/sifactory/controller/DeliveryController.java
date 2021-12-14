package apap.ta.sifactory.controller;

import apap.ta.sifactory.model.DeliveryModel;
import apap.ta.sifactory.model.PegawaiModel;
import apap.ta.sifactory.model.RequestUpdateItemModel;
import apap.ta.sifactory.service.DeliveryService;
import apap.ta.sifactory.service.PegawaiService;
import apap.ta.sifactory.service.RequestUpdateItemService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    private PegawaiService pegawaiService;

    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private RequestUpdateItemService requestUpdateItemService;

    // @Autowired
    // private DeliveryRestService deliveryRestService;

    //Fitur 12
    //Daftar request update item kalo executed True ada button Buat Delivery
    @GetMapping("/assign-kurir/{idRequestUpdateItem}")
    private String assignKurirForm(
            @PathVariable Integer idRequestUpdateItem,
            Model model
    ) {
        List<PegawaiModel> listKurir = pegawaiService.getKurir();
        model.addAttribute("listKurir",listKurir);
        model.addAttribute("idRequestUpdateItem",idRequestUpdateItem);
        model.addAttribute("delivery", new DeliveryModel());
        return "form-assign-kurir";
    }

    @PostMapping("/assign-kurir/{idRequestUpdateItem}")
    private String assignKurirPost(
            @ModelAttribute DeliveryModel delivery,
            @PathVariable Integer idRequestUpdateItem,
            Model model
    ) {
        RequestUpdateItemModel getRequest = requestUpdateItemService.getRequestById(idRequestUpdateItem);
        getRequest.setDelivery(delivery);
        delivery.setRequestUpdate(getRequest);
        delivery.setIdCabang(delivery.getRequestUpdate().getIdCabang());
        delivery.setSent(false);
        delivery.getPegawai().getListDelivery().add(delivery);
        delivery.setTanggalDibuat(LocalDate.now());
        deliveryService.addDelivery(delivery);

        String nama = SecurityContextHolder.getContext().getAuthentication().getName();//get pegawai yang input
        pegawaiService.addCounterPegawai(nama);
        model.addAttribute("action", "assign delivery");
        model.addAttribute("tipe", "kurir");
        return "success-page";
    }

    //Fitur 13
    @GetMapping(value = "/daftar-delivery")
    public String viewAllDelivery(
            Model model
    ){
        //get rolenya dulu, kalo staff op dia get all delivery
        //kalo kurir, get delivery yang id kurirnya dia
        String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
        System.out.println(role);
        if (role.equals("[STAFF_OPERASIONAL]")){
            List<DeliveryModel> listDelivery = deliveryService.getAllDelivery();
            model.addAttribute("listDelivery", listDelivery);
        }
        else if (role.equals("[STAFF_KURIR]")){
            String nama = SecurityContextHolder.getContext().getAuthentication().getName();
            PegawaiModel kurir = pegawaiService.getPegawai(nama);
            List<DeliveryModel> listDelivery = deliveryService.getDeliveryByKurir(kurir);
            model.addAttribute("listDelivery", listDelivery);
        }
        model.addAttribute("role", role);
        return "list-delivery";
    }

    //Fitur 14
    @GetMapping(value = "/kirim-delivery/{idDelivery}")
    public String sentDelivery(
        @PathVariable Integer idDelivery,
        @ModelAttribute DeliveryModel deliveryModel,
        Model model
    ) throws JSONException {
        String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
        if (role.equals("[STAFF_KURIR]")){
            model.addAttribute("role", role);
            model.addAttribute("idDelivery", idDelivery);
            DeliveryModel delivery = deliveryService.getDeliveryByIdDelivery(idDelivery);
            if (deliveryService.checkCabang(delivery.getIdCabang()) == true){
                boolean flag = true;
                delivery.setSent(flag);
                model.addAttribute("alamat", deliveryService.returnAlamat(delivery.getIdCabang()));
                String name = SecurityContextHolder.getContext().getAuthentication().getName();
                pegawaiService.addCounterPegawai(name);
                return "success-kirim";
            }
        }
        return "failed-kirim";
    }
}
