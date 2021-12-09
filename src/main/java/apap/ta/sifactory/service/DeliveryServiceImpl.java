package apap.ta.sifactory.service;

import apap.ta.sifactory.model.DeliveryModel;
import apap.ta.sifactory.model.PegawaiModel;
import apap.ta.sifactory.repository.DeliveryDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService{
    @Autowired
    private DeliveryDB deliveryDB;

    @Override
    public List<DeliveryModel> getAllDelivery() {
        return deliveryDB.findAll();
    }

    @Override
    public List<DeliveryModel> getDeliveryByKurir(PegawaiModel kurir) {
        return deliveryDB.findAllByPegawai(kurir);
    }
}
