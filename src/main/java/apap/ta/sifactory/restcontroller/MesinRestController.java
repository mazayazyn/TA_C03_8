package apap.ta.sifactory.restcontroller;

import apap.ta.sifactory.model.MesinModel;
import apap.ta.sifactory.rest.BaseResponse;
import apap.ta.sifactory.rest.MesinDetail;
import apap.ta.sifactory.service.MesinRestService;
import apap.ta.sifactory.service.MesinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class MesinRestController {
    @Autowired
    private MesinService mesinService;

    @Autowired
    private MesinRestService mesinRestService;

    @GetMapping(value = "/mesin/{idMesin}")
    private MesinModel retrieveMesin(@PathVariable("idMesin") Integer idMesin) {
        try {
            return mesinService.getMesinByIdMesin(idMesin);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Id Mesin " + String.valueOf(idMesin) + " Not Found,"
            );
        }
    }

    @GetMapping(value = "/list-mesin")
    private BaseResponse<List<MesinDetail>> getListMesin() {
        BaseResponse<List<MesinDetail>> response = new BaseResponse<>();
        response.setStatus(200);
        response.setMessage("Success");
        List<MesinModel> listMesinModel = mesinService.getAllMesin();
        List<MesinDetail> listMesinDetail= new ArrayList<>();
        for (MesinModel m:listMesinModel){
            MesinDetail detail = new MesinDetail();
            detail.setIdMesin(m.getIdMesin());
            detail.setNama(m.getNama());
            detail.setIdKategori(m.getIdKategori());
            detail.setTanggalDibuat(m.getTanggalDibuat());
            detail.setKapasitas(m.getKapasitas());

            listMesinDetail.add(detail);
        }
        response.setResult(listMesinDetail);
        return response;
    }

}