package apap.ta.sifactory.service;

import apap.ta.sifactory.model.PegawaiModel;

public interface PegawaiService {
    PegawaiModel addPegawai(PegawaiModel pegawai);
    PegawaiModel getPegawai(String username);
    void addCounterPegawai(String username);
    String encrypt(String password);
}