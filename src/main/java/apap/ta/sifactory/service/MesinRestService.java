package apap.ta.sifactory.service;

import java.util.List;
import apap.ta.sifactory.model.MesinModel;
import apap.ta.sifactory.rest.ItemDetail;
import apap.ta.sifactory.rest.ListMesinDetail;
import apap.ta.sifactory.rest.MesinDetail;
import reactor.core.publisher.Mono;

public interface MesinRestService {
    List<MesinDetail> getAllMesin();
}