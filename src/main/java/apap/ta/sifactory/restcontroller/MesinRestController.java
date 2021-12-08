package apap.ta.sifactory.restcontroller;

import apap.ta.sifactory.model.MesinModel;
import apap.ta.sifactory.service.MesinRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class MesinRestController {
    @Autowired
    private MesinRestService mesinRestService;

    @GetMapping(value = "/list-mesin")
    private List<MesinModel> retrieveListMesin(){
        return mesinRestService.getAllMesin();
    }

    @GetMapping(value = "/mesin/{idMesin}")
    private MesinModel retrieveMesin(@PathVariable("idMesin") Integer idMesin) {
        try {
            return mesinRestService.getMesinByIdMesin(idMesin);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Id Mesin " + String.valueOf(idMesin) + " Not Found,"
            );
        }
    }
}