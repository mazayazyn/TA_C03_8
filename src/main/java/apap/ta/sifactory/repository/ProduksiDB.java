package apap.ta.sifactory.repository;

import apap.ta.sifactory.model.ProduksiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduksiDB extends JpaRepository<ProduksiModel, Integer>{
}