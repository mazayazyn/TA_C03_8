package apap.ta.sifactory.repository;

import apap.ta.sifactory.model.DeliveryModel;
import apap.ta.sifactory.model.ProduksiModel;
import apap.ta.sifactory.model.RequestUpdateItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface ProduksiDB extends JpaRepository<ProduksiModel, Integer>{
    ProduksiModel findByIdItem(String req);
    ProduksiModel findByIdProduksi(Integer idProduksi);
}