package apap.ta.sifactory.service;

import apap.ta.sifactory.model.DeliveryModel;
import apap.ta.sifactory.model.PegawaiModel;

import java.util.List;

public interface DeliveryService {
    List<DeliveryModel> getAllDelivery();
    List<DeliveryModel> getDeliveryByKurir(PegawaiModel kurir);
}
