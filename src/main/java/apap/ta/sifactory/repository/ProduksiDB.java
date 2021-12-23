package apap.ta.sifactory.repository;

import apap.ta.sifactory.model.ProduksiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProduksiDB extends JpaRepository<ProduksiModel, Integer>{
    List<ProduksiModel> findAllByIdItem(String req);
}