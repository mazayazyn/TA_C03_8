package apap.ta.sifactory.service;

import java.util.List;
import apap.ta.sifactory.model.MesinModel;

public interface MesinService {
    List<MesinModel> getAllMesin();
    MesinModel getMesinByIdMesin(Integer idMesin);
}
