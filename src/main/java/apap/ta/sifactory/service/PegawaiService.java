package apap.ta.sifactory.service;

import apap.ta.sifactory.model.PegawaiModel;
import java.util.List;

public interface PegawaiService {
    PegawaiModel addPegawai(PegawaiModel pegawai);
    PegawaiModel getPegawai(String username);
    void addCounterPegawai(String username);
    List<PegawaiModel> getDaftarPegawai();
    String encrypt(String password);
}