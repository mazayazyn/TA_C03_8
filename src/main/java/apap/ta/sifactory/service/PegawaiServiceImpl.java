package apap.ta.sifactory.service;

import apap.ta.sifactory.model.PegawaiModel;
import apap.ta.sifactory.repository.PegawaiDB;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PegawaiServiceImpl implements PegawaiService{
    @Autowired
    private PegawaiDB pegawaiDB;

    @Override
    public PegawaiModel addPegawai(PegawaiModel pegawai) {
//        String pass = encrypt(pegawai.getPassword());
//        user.setPassword(pass);
        return pegawaiDB.save(pegawai);
    }
}
