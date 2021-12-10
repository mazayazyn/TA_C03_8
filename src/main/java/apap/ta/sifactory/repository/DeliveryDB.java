package apap.ta.sifactory.repository;

import apap.ta.sifactory.model.DeliveryModel;
import apap.ta.sifactory.model.PegawaiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface DeliveryDB extends JpaRepository<DeliveryModel, Integer>{
    List<DeliveryModel> findAllByPegawai(PegawaiModel pegawai);
    Optional<DeliveryModel> findByIdDelivery(Integer idDelivery);
}