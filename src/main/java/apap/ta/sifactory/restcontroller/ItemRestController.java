package apap.ta.sifactory.restcontroller;

import apap.ta.sifactory.rest.ItemDetail;
import apap.ta.sifactory.service.ItemRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class ItemRestController {
    @Autowired
    private ItemRestService itemRestService;

    //Fitur 5
    @GetMapping(value="/listItem")
    private List<ItemDetail> getAllItem(){
        try {
            return itemRestService.getAllItem();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "List item not found"
            );
        }
    }
}
