package apap.ta.sifactory.service;

import apap.ta.sifactory.model.RequestUpdateItemModel;
import apap.ta.sifactory.repository.RequestUpdateItemDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class RequestUpdateItemServiceImpl implements RequestUpdateItemService{
    @Autowired
    private RequestUpdateItemDB requestUpdateItemDB;

    @Override
    public List<RequestUpdateItemModel> getAllRequest() {
        return requestUpdateItemDB.findAll();
    }

    @Override
    public RequestUpdateItemModel getRequestById(Integer id) {
        Optional<RequestUpdateItemModel> request = requestUpdateItemDB.findByIdRequestUpdateItem(id);
        if(request.isPresent()){
            return request.get();
        } else {
            throw new NoSuchElementException();
        }
    }

}
