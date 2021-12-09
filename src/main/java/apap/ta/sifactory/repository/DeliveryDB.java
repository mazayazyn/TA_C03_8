package apap.ta.sifactory.repository;

import apap.ta.sifactory.model.DeliveryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DeliveryDB extends JpaRepository<DeliveryModel, Integer>{
}