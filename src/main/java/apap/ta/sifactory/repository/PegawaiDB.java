package apap.ta.sifactory.repository;

import apap.ta.sifactory.model.PegawaiModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PegawaiDB extends JpaRepository<PegawaiModel, Integer>{
    PegawaiModel findByUsername(String username);
}
