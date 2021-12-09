package apap.ta.sifactory.service;

import apap.ta.sifactory.model.MesinModel;
import apap.ta.sifactory.repository.MesinDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class MesinServiceImpl implements MesinService{
    @Autowired
    MesinDB mesinDB;

    @Override
    public List<MesinModel> getAllMesin() {
        return mesinDB.findAll();
    }

    @Override
    public MesinModel getMesinByIdMesin(Integer idMesin) {
        Optional<MesinModel> mesin = mesinDB.findByIdMesin(idMesin);

        if(mesin.isPresent()){
            return mesin.get();
        } else {
            throw new NoSuchElementException();
        }
    }
}
