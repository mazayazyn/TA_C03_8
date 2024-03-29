package apap.ta.sifactory.service;

import apap.ta.sifactory.model.PegawaiModel;
import apap.ta.sifactory.repository.PegawaiDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PegawaiServiceImpl implements PegawaiService{
    @Autowired
    private PegawaiDB pegawaiDB;

    @Override
    public PegawaiModel addPegawai(PegawaiModel pegawai) {
        String pass = encrypt(pegawai.getPassword());
        pegawai.setPassword(pass);
        return pegawaiDB.save(pegawai);
    }

    @Override
    public PegawaiModel getPegawai(String username) {
        PegawaiModel getPegawai = pegawaiDB.findByUsername(username);
        if(getPegawai!=null){//jika ada pegawai dengan username
            return getPegawai;
        }
        return null;
    }

    @Override
    public void addCounterPegawai(String username) {
        PegawaiModel pegawai = getPegawai(username);
        Integer counterb = pegawai.getCounter();
        pegawai.setCounter(counterb+1);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public List<PegawaiModel> getDaftarPegawai() {
        return pegawaiDB.findAll();
    }

    @Override
    public List<PegawaiModel> getKurir() {
        List<PegawaiModel> listP = getDaftarPegawai();
        List<PegawaiModel> listKurir = new ArrayList<>();
        for (PegawaiModel p:listP){
            if(p.getRole().getNamaRole().equals("STAFF_KURIR")){
                listKurir.add(p);
            }
        }
        return listKurir;
    }

}