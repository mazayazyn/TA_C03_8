package apap.ta.sifactory.restcontroller;

import apap.ta.sifactory.model.RequestUpdateItemModel;
import apap.ta.sifactory.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1")
public class SifactoryRestController {

    @Autowired
    private ItemService itemService;

    @PostMapping(value= "/request-update-item")
    private RequestUpdateItemModel requestUpdateItem(@Valid @RequestBody RequestUpdateItemModel req, BindingResult bindingResult ) {
        if(bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field." + bindingResult
            );
        }
        else {
            return itemService.createRequest(req);
        }
    }
}
