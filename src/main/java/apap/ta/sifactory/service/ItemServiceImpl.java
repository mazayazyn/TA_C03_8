package apap.ta.sifactory.service;

import apap.ta.sifactory.model.RequestUpdateItemModel;
import apap.ta.sifactory.repository.RequestUpdateItemDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RequestUpdateItemDB requestUpdateItemDB;

    @Override
    public RequestUpdateItemModel createRequest(RequestUpdateItemModel req) {
        return requestUpdateItemDB.save(req);
    }
}
