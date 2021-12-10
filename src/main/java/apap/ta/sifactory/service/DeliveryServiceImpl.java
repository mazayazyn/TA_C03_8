package apap.ta.sifactory.service;

import apap.ta.sifactory.model.DeliveryModel;
import apap.ta.sifactory.model.PegawaiModel;
import apap.ta.sifactory.repository.DeliveryDB;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService{
    @Autowired
    private DeliveryDB deliveryDB;

    @Autowired
    private DeliveryRestService deliveryRestService;

    @Autowired
    private DeliveryService deliveryService;

    @Override
    public List<DeliveryModel> getAllDelivery() {
        return deliveryDB.findAll();
    }

    @Override
    public List<DeliveryModel> getDeliveryByKurir(PegawaiModel kurir) {
        return deliveryDB.findAllByPegawai(kurir);
    }

    @Override
    public boolean checkCabang (Integer idCabang) throws JSONException {
        String s = deliveryRestService.getListIdCabang().share().block();
        JSONObject jsonObject = new JSONObject(s);
        JSONArray listDatabase = jsonObject.getJSONArray("listCabang");
        for (int i=0; i<listDatabase.length(); i++){
            listDatabase.getJSONObject(i).get("alamat");
            if (listDatabase.getJSONObject(i).get("id_cabang").equals(idCabang)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String returnAlamat (Integer idCabang) throws JSONException {
        String s = deliveryRestService.getListIdCabang().share().block();
        JSONObject jsonObject = new JSONObject(s);
        JSONArray listDatabase = jsonObject.getJSONArray("listCabang");
        for (int i=0; i<listDatabase.length(); i++){
            if (listDatabase.getJSONObject(i).get("id_cabang").equals(idCabang)){
                return (String) listDatabase.getJSONObject(i).get("alamat");
            }
        }
        return null;
    }

    @Override
    public DeliveryModel getDeliveryByIdDelivery(Integer idDelivery) {
        Optional<DeliveryModel> delivery = deliveryDB.findByIdDelivery(idDelivery);
        if (delivery.isPresent()) {
            return delivery.get();
        }
        return null;
    }

}
