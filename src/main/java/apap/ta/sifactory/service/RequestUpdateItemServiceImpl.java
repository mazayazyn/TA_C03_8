package apap.ta.sifactory.service;

import apap.ta.sifactory.model.RequestUpdateItemModel;
import apap.ta.sifactory.repository.RequestUpdateItemDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RequestUpdateItemServiceImpl implements RequestUpdateItemService{
    @Autowired
    private RequestUpdateItemDB requestUpdateItemDB;

    @Override
    public List<RequestUpdateItemModel> getAllRequest() {
        return requestUpdateItemDB.findAll();
    }

}
