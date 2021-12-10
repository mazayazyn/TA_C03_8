package apap.ta.sifactory.service;

import apap.ta.sifactory.model.DeliveryModel;
import apap.ta.sifactory.model.PegawaiModel;
import org.json.JSONException;

import java.util.List;

public interface DeliveryService {
    List<DeliveryModel> getAllDelivery();
    List<DeliveryModel> getDeliveryByKurir(PegawaiModel kurir);
    boolean checkCabang (Integer idCabang) throws JSONException;
    DeliveryModel getDeliveryByIdDelivery(Integer idDelivery);
    String returnAlamat (Integer idCabang) throws JSONException;
}
