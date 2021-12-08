package apap.ta.sifactory.service;

import apap.ta.sifactory.model.PegawaiModel;

public interface PegawaiService {
    PegawaiModel addPegawai(PegawaiModel pegawai);
    String encrypt(String password);

}