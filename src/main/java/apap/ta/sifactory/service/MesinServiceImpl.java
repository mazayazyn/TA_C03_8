package apap.ta.sifactory.service;

import apap.ta.sifactory.model.MesinModel;
import apap.ta.sifactory.repository.MesinDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MesinServiceImpl implements MesinService{
    @Autowired
    MesinDB mesinDB;

    @Override
    public List<MesinModel> getAllMesin() {
        return mesinDB.findAll();
    }
}
